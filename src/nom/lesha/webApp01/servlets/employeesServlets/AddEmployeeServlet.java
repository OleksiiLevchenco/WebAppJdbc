package nom.lesha.webApp01.servlets.employeesServlets;



import nom.lesha.webApp01.model.Employee;
import nom.lesha.webApp01.model.Shop;
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
public class AddEmployeeServlet extends HttpServlet {

    String okRef = "dispatcher";
    String failRef = "WEB-INF/employeesJsp/HandleEmployee.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req = EmployeeService.validateAndParsEmployeesParams(req);
        Employee employee = (Employee) req.getAttribute("employee");

        if (req.getAttribute("employeeValidationReport") == null) {
            boolean success = EmployeeService.addItem(employee);
            if (success) {
                req.setAttribute("action", "to.employee.list");
                RequestDispatcher dispatcher = req.getRequestDispatcher(okRef);
                dispatcher.forward(req, resp);
            } else {
                resp.setContentType("text/html");
                resp.getWriter().print("<h2><font color='#ff7f50'>Data base error...</font></h2>");
            }
        } else {
            req.setAttribute("action", "to.employee.add");
            RequestDispatcher dispatcher = req.getRequestDispatcher(failRef);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
