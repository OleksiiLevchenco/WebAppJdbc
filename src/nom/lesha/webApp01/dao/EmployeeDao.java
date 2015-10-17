package nom.lesha.webApp01.dao;


import nom.lesha.webApp01.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Alexey Levchenko
 */
public class EmployeeDao /*extends ServletContextListener*/ /*extends HttpServlet*/ {

    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_CONNECTION = "jdbc:mysql://localhost:3306/study";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "serverPassword";
    private static Connection connection = getDbConnect();



    private static Connection getDbConnect() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return dbConnection;
    }

    public static boolean addItem(String name, int shop){
        String sql = "INSERT INTO employees (name, shop) VALUES(?,?);";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2, shop);

            if(statement.executeUpdate()>0){
                result=true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;
    }

    public static boolean addItem(Employee employee) {
        String sql = "INSERT INTO employees (name, shop) VALUES(?,?);";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getName());
            statement.setInt(2, employee.getShop());

            if(statement.executeUpdate()>0){
                result=true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;
    }

    public static boolean update(int id, String name, int shop) {
        String sql = "UPDATE employees SET " +
                "name=?" +
                ",shop=?" +
                "WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2,shop);
            statement.setInt(3,id);
            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean update(Employee employee) {
        String sql = "UPDATE employees SET " +
                "name=?" +
                "WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getName());
            statement.setInt(2,employee.getId());
            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean delete(int id){
        String sql = "DELETE FROM employees WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static ResultSet getResultSet(String sql){
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public static PreparedStatement getPreparedStatement(String sql){
        try {
            return connection.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Employee getEmployeeById(int id){
        String sql = "SELECT* FROM employees WHERE id=?";
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =  preparedStatement.executeQuery();

            resultSet.next();
            employee.setId(resultSet.getInt(1));
            employee.setName (resultSet.getString(2));
            employee.setShop(resultSet.getInt(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getEmployeesList(){

        List<Employee> employeesList = new ArrayList<>();
        String sql = "SELECT* FROM employees;";

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                Employee tmp = new Employee();

                tmp.setId(result.getInt(1));
                tmp.setName (result.getString(2));
                tmp.setShop(result.getInt(3));

                employeesList.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }

    public static List<Employee> getEmployeesListByShopId(int shopId) {
        List<Employee> employeesList = new ArrayList<>();
        String sql = "SELECT* FROM employees WHERE shop=?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,shopId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Employee tmp = new Employee();

                tmp.setId(result.getInt(1));
                tmp.setName(result.getString(2));
                tmp.setShop(result.getInt(3));

                employeesList.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }

//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//    }

}

