package nom.lesha.webApp01.services;



import nom.lesha.webApp01.model.Employee;
import nom.lesha.webApp01.dao.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexey Levchenko
 */
public class EmployeeService {

    public static List<Employee> getEmployeesListByShopId(int shopId) {
        return EmployeeDao.getEmployeesListByShopId(shopId);
    }

    public static Employee getEmployeeById(int id) {
        return EmployeeDao.getEmployeeById(id);
    }

    public static HttpServletRequest validateAndParsEmployeesParams(HttpServletRequest req) {
        int id = -1;
        String name = "";
        int employeesShopId = -1;

        String idStr = req.getParameter("employeeId");
        if (idStr == null) {
            idStr = (String) req.getAttribute("employeeId");
        }
        if (idStr == null) {
            idStr = "-1";
        }
        id = Integer.parseInt(idStr);

        String shopIdStr = req.getParameter("shopId");
        if (shopIdStr == null) {
            shopIdStr = (String) req.getAttribute("shopId");
        }
        if (shopIdStr == null) {
            shopIdStr = "-1";
        }
        employeesShopId = Integer.parseInt(shopIdStr);

        Map<String, String> employeeValidationReport = new LinkedHashMap<>();


        Employee employee = new Employee();

        if (stringLengthValidate(req.getParameter("employeeName"), 45)) {
            name = req.getParameter("employeeName");
        } else {
            employeeValidationReport.put("name", "This field should not be empty, and can not contain more than 45 characters");
        }

        employee.setName(name);
        employee.setShop(employeesShopId);
        employee.setId(id);


        if (employeeValidationReport.size() != 0) {
            req.setAttribute("employeeValidationReport", employeeValidationReport);
        }

        req.setAttribute("employee", employee);

        return req;
    }


    private static boolean stringLengthValidate(String string, int length) {
        return !(string == null || string.equals("")) && (string.length() <= length);
    }

    public static boolean addItem(Employee employee) {
        return EmployeeDao.addItem(employee);
    }

    public static boolean update(Employee employee) {
        return EmployeeDao.update(employee);
    }

    public static boolean delete(int id) {
        return EmployeeDao.delete(id);
    }
}
