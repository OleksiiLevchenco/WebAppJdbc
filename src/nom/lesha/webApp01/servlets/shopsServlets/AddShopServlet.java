package nom.lesha.webApp01.servlets.shopsServlets;



import nom.lesha.webApp01.model.Shop;
import nom.lesha.webApp01.model.Transformer;
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
public class AddShopServlet extends HttpServlet {

    String okRef = "dispatcher";
    String failRef = "WEB-INF/shopsJsp/HandleShop.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req = ShopService.validateAndParsShopsParams(req);
        Shop shop = (Shop) req.getAttribute("shop");

        if (req.getAttribute("shopValidationReport") == null) {
            boolean success = ShopService.addItem(shop);
            if (success) {
                req.setAttribute("action", "to.shop.list");
                RequestDispatcher dispatcher = req.getRequestDispatcher(okRef);
                dispatcher.forward(req, resp);
            } else {
                resp.setContentType("text/html");
                resp.getWriter().print("<h2><font color='#ff7f50'>Data base error...</font></h2>");
            }
        } else {
            req.setAttribute("action", "to.shop.add");
            RequestDispatcher dispatcher = req.getRequestDispatcher(failRef);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
