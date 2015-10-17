package nom.lesha.webApp01.servlets;


import nom.lesha.webApp01.services.EmployeeService;
import nom.lesha.webApp01.services.ShopService;
import nom.lesha.webApp01.services.TransformerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Levchenko
 */
public class DispatcherServlet extends HttpServlet {
    private Map<String, String> actionRef = new HashMap<String, String>() {{
//        Transformer
        put("to.transformer.add", "WEB-INF/transformersJsp/HandleTransformer.jsp");
        put("to.transformer.edit", "WEB-INF/transformersJsp/HandleTransformer.jsp");
        put("to.transformer.delete", "WEB-INF/transformersJsp/HandleTransformer.jsp");
        put("to.transformer.list", "WEB-INF/transformersJsp/TransformersList.jsp");

//        Shop
        put("to.shop.add", "WEB-INF/shopsJsp/HandleShop.jsp");
        put("to.shop.edit", "WEB-INF/shopsJsp/HandleShop.jsp");
        put("to.shop.delete", "WEB-INF/shopsJsp/HandleShop.jsp");
        put("to.shop.list", "WEB-INF/shopsJsp/ShopsList.jsp");

//        Employee
        put("to.employee.list", "WEB-INF/employeesJsp/EmployeeList.jsp");
        put("to.employee.add", "WEB-INF/employeesJsp/HandleEmployee.jsp");
        put("to.employee.edit", "WEB-INF/employeesJsp/HandleEmployee.jsp");
        put("to.employee.delete", "WEB-INF/employeesJsp/HandleEmployee.jsp");
    }};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = (String) req.getAttribute("action");
        }
        if (action == null) {
            action = "";
        }

        switch (action) {
//            Transformer
            case "to.transformer.add":
                req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                break;
            case "to.transformer.edit": {
                if (req.getParameter("transformer.id") != null) {
                    int id = Integer.parseInt(req.getParameter("transformer.id"));
                    req.setAttribute("transformer", TransformerService.getTransformerById(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found, error...");
                }
                break;
            }
            case "to.transformer.delete": {
                if (req.getParameter("transformer.id") != null) {
                    int id = Integer.parseInt(req.getParameter("transformer.id"));
                    req.setAttribute("transformer", TransformerService.getTransformerById(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found, error...");
                }
                break;
            }
            case "to.transformer.list": {
                req.setAttribute("transformersList", TransformerService.getTransformersList());
                req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                break;
            }
//            Shop
            case "to.shop.add":
                req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                break;
            case "to.shop.edit": {
                if (req.getParameter("shopId") != null) {
                    int id = Integer.parseInt(req.getParameter("shopId"));
                    req.setAttribute("shop", ShopService.getShopById(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found error...");
                }
                break;
            }
            case "to.shop.delete": {
                if (req.getParameter("shopId") != null) {
                    int id = Integer.parseInt(req.getParameter("shopId"));
                    req.setAttribute("shop", ShopService.getShopById(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found error...");
                }
                break;
            }
            case "to.shop.list": {
                req.setAttribute("shopsList", ShopService.getShopsList());
                req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                break;
            }

//            Employee
            case "to.employee.list": {
                if (req.getParameter("shopId") != null) {
                    int id = Integer.parseInt(req.getParameter("shopId"));
                    req.setAttribute("employeesList", ShopService.getShopsEmployeesList(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found error...");
                }
                break;
            }
            case "to.employee.add": {
                req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                break;
            }
            case "to.employee.edit": {
                if (req.getParameter("employeeId") != null) {
                    int id = Integer.parseInt(req.getParameter("employeeId"));
                    req.setAttribute("employee", EmployeeService.getEmployeeById(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found error...");
                }
                break;
            }
            case "to.employee.delete": {
                if (req.getParameter("employeeId") != null) {
                    int id = Integer.parseInt(req.getParameter("employeeId"));
                    req.setAttribute("employee", EmployeeService.getEmployeeById(id));
                    req.getRequestDispatcher(actionRef.get(action)).forward(req, resp);
                } else {
                    resp.getWriter().print("id not found error...");
                }
                break;
            }

            default:
                resp.getWriter().print("Dispatcher error, case not found");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
