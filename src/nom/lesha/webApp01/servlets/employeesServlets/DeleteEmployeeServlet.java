package nom.lesha.webApp01.servlets.employeesServlets;


import nom.lesha.webApp01.services.EmployeeService;
import nom.lesha.webApp01.services.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alexey Levchenko
 */
public class DeleteEmployeeServlet extends HttpServlet {
    String okRef = "dispatcher";
    String failRef = "WEB-INF/employeesJsp/HandleEmployee.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("employeeId") != null){
            int id = Integer.parseInt(req.getParameter("employeeId"));
            boolean success = EmployeeService.delete(id);
            if (success) {
                req.setAttribute("action", "to.employee.list");
                RequestDispatcher dispatcher = req.getRequestDispatcher(okRef);
                dispatcher.forward(req, resp);
            } else {
                resp.setContentType("text/html");
                resp.getWriter().print("<h2><font color='#ff7f50'>Data base error...</font></h2>");
                req.setAttribute("action", "to.employee.delete");
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
