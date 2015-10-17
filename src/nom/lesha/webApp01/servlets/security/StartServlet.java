package nom.lesha.webApp01.servlets.security;

import nom.lesha.webApp01.dao.EmployeeDao;
import nom.lesha.webApp01.dao.ShopDao;
import nom.lesha.webApp01.dao.TransformersDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alexey Levchenko
 */
public class StartServlet extends HttpServlet {
    String transformersListRef = "WEB-INF/transformersJsp/TransformersList.jsp";
    String employeesListRef = "WEB-INF/employeesJsp/EmployeeList.jsp";
    String shopsListRef = "WEB-INF/shopsJsp/ShopsList.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        switch (action){
            case "to.Transformers.List": {
                req.setAttribute("transformersList", TransformersDao.getTransformersList());
                req.getRequestDispatcher(transformersListRef).forward(req,resp);
                break;
            }

            case "to.Employees.List" : {
                req.setAttribute("employeesList", EmployeeDao.getEmployeesList());
                req.getRequestDispatcher(employeesListRef).forward(req,resp);
                break;
            }

            case "to.Shops.List" : {
                req.setAttribute("shopsList", ShopDao.getShopsList());
                req.getRequestDispatcher(shopsListRef).forward(req,resp);
                break;
            }

            default: {
                resp.getWriter().print("Page not found...");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
