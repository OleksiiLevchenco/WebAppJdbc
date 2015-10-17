package nom.lesha.webApp01.servlets.transformersServlets;


import nom.lesha.webApp01.services.TransformerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alexey Levchhenko
 */
public class DeleteTransformerServlet extends HttpServlet {
    String okRef = "dispatcher";
    String failRef = "WEB-INF/transformersJsp/HandleTransformer.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("transformer.id"));

        boolean success = TransformerService.delete(id);
        if (success) {
            req.setAttribute("action", "to.transformer.list");
            RequestDispatcher dispatcher = req.getRequestDispatcher(okRef);
            dispatcher.forward(req, resp);
        } else {
            resp.setContentType("text/html");
            resp.getWriter().print("<h2><font color='#ff7f50'>Data base error...</font></h2>");
            req.setAttribute("action", "to.transformer.delete");
            RequestDispatcher dispatcher = req.getRequestDispatcher(failRef);
            dispatcher.include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
