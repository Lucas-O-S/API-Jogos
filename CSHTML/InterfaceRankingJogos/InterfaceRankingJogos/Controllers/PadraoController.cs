using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace InterfaceRankingJogos.Controllers
{
    public abstract class PadraoController<T> : Controller where T : PadraoViewModel
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            if (!HelperDAO.ServerChecker().GetAwaiter().GetResult())
            {
                context.Result = RedirectToAction("Error", "Home", new { erro = "Server não está em funcionamento"});
            }
            base.OnActionExecuting(context);

        }
        protected PadraoDAO<T> dao { get; set; }
        protected virtual void ValidarDados(T model, string operacao)
        {
            ModelState.Clear();
        }
     
        protected virtual void ViewBags() { } 

        public virtual IActionResult Index()
        {
            try
            {
                var list = dao.GetAll();
                return View("index", list);
            }
            catch(Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));
            }

        }

        public virtual IActionResult Insert() {
            ViewBag.operacao = "I";
            ViewBags();
			T model = Activator.CreateInstance(typeof(T)) as T;
            return View ("form", model);
        }

        public virtual IActionResult Update(Guid id)
        {
            ViewBag.operacao = "E";
			ViewBags();

			T model = dao.Get(id);

            return View("form", model);
        }

        public IActionResult Delete(Guid id)
        {
            try
            {
                if (dao.Get(id) != null) 
                    dao.Delete(id);
                    
                return RedirectToAction("Index");

            }
            catch (Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));

            }
        }

        public virtual ActionResult Enviar(T model, string operacao)
        {
            try
            {
                ValidarDados (model, operacao);
                if (operacao == "I")
                {
                    model.id = Guid.NewGuid();
                    dao.Post(model);
                }
                else
                {
                    dao.Put(model);
                }
                return RedirectToAction("Index");
            }
            catch (Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));

            }
        }
    }
}
