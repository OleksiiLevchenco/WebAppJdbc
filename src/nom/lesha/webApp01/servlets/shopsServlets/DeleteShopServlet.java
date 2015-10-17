package nom.lesha.webApp01.servlets.shopsServlets;


import nom.lesha.webApp01.services.ShopService;
import nom.lesha.webApp01.services.TransformerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alexey Levchenko
 */
public class DeleteShopServlet extends HttpServlet {
    String okRef = "dispatcher";
    String failRef = "WEB-INF/ShopsJsp/HandleShop.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("shopId") != null){
            int id = Integer.parseInt(req.getParameter("shopId"));
            boolean success = ShopService.delete(id);
            if (success) {
                req.setAttribute("action", "to.shop.list");
                RequestDispatcher dispatcher = req.getRequestDispatcher(okRef);
                dispatcher.forward(req, resp);
            } else {
                resp.setContentType("text/html");
                resp.getWriter().print("<h2><font color='#ff7f50'>Data base error...</font></h2>");
                req.setAttribute("action", "to.shop.delete");
                RequestDispatcher dispatcher = req.getRequestDispatcher(failRef);
                dispatcher.include(req, resp);
            }
        } else {
            resp.getWriter().print("id no found, error...");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
