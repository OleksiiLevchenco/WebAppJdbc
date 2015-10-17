package nom.lesha.webApp01.servlets.security;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Alexey Levchenko
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        String login = (String)req.getParameter("login");
////        if (login == null){
////            login = (String)req.getSession().getAttribute("login");
////            if (login == null){
////                RequestDispatcher dispatcher = req.getRequestDispatcher("login");
////                dispatcher.forward(req,resp);
////            } else return;
////        }
//
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        TransformersDao DbConnection = new TransformersDao();
//        if(DbConnection.validateUser(login, password)){
//            req.getSession().setAttribute("login",login);
//            RequestDispatcher rd = req.getRequestDispatcher("TransformersList.jsp");
//            rd.forward(req, resp);
//        } else {
//            RequestDispatcher rd = req.getRequestDispatcher("register_or_illegal_login.jsp");
//            rd.include(req, resp);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
