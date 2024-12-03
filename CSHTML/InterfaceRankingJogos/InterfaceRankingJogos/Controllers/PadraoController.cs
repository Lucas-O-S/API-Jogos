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
        public IActionResult Index()
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

        public IActionResult Insert() {
            ViewBag.operacao = "I";
            T model = Activator.CreateInstance(typeof(T)) as T;
            return View ("form", model);
        }

        public IActionResult Update(T model)
        {
            ViewBag.operacao = "E";
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

        public ActionResult Enviar(T model, string operacao)
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
