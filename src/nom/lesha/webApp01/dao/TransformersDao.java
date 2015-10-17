package nom.lesha.webApp01.dao;



import nom.lesha.webApp01.model.Transformer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Alexey Levchenko
 */
public class TransformersDao /*extends ServletContextListener*/ /*extends HttpServlet*/ {

    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_CONNECTION = "jdbc:mysql://localhost:3306/study";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "serverPassword";
    private static Connection connection = getDbConnect();


//    @Override
//    public void init() throws ServletException {
//        ServletConfig config = getServletConfig();
//        DB_DRIVER = config.getInitParameter("driver");
//        DB_CONNECTION = config.getInitParameter("connection_url");
//        DB_USER = config.getInitParameter("user");
//        DB_PASSWORD = config.getInitParameter("password");
//        connection = getDbConnect();
//    }

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

    public static boolean validateUser(String login, String password) {
        String sql = "SELECT* FROM users WHERE user_login=? and user_password=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static boolean addItem(int inputVoltage, int outputVoltage, int outputCurrent,
                                  int mass, BigDecimal price){
        String sql = "INSERT INTO transformers(input_voltage, output_voltage, output_current, mass, price)" +
                " VALUES(?,?,?,?,?)";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, inputVoltage);
            statement.setInt(2, outputVoltage);
            statement.setInt(3, outputCurrent);
            statement.setInt(4, mass);
            statement.setBigDecimal(5, price);
            if(statement.executeUpdate()>0){
                result=true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;
    }

    public static boolean addItem(Transformer transformer) {

        String sql = "INSERT INTO transformers(input_voltage, output_voltage, output_current, mass, price)" +
                " VALUES(?,?,?,?,?)";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, transformer.getOutputVoltage());
            statement.setInt(2, transformer.getOutputVoltage());
            statement.setInt(3, transformer.getOutputCurrent());
            statement.setInt(4, transformer.getMass());
            statement.setBigDecimal(5, transformer.getPrice());
            if(statement.executeUpdate()>0){
                result=true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;

    }

    public static boolean update(int id, int inputVoltage,
                                 int outputVoltage, int outputCurrent,
                                 int mass, BigDecimal price) {
        String sql = "UPDATE transformers SET " +
                "input_voltage=?" +
                ",output_voltage=?" +
                ",output_current=?" +
                ",mass=?" +
                ",price=?" +
                "WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, inputVoltage);
            statement.setInt(2, outputVoltage);
            statement.setInt(3, outputCurrent);
            statement.setInt(4, mass);
            statement.setBigDecimal(5, price);
            statement.setInt(6, id);
            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean update(Transformer transformer) {
        String sql = "UPDATE transformers SET " +
                "input_voltage=?" +
                ",output_voltage=?" +
                ",output_current=?" +
                ",mass=?" +
                ",price=?" +
                "WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transformer.getInputVoltage());
            statement.setInt(2, transformer.getOutputVoltage());
            statement.setInt(3, transformer.getOutputCurrent());
            statement.setInt(4, transformer.getMass());
            statement.setBigDecimal(5, transformer.getPrice());
            statement.setInt(6,transformer.getId());

            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean delete(int id){
        String sql = "DELETE FROM transformers WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
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

    public static Transformer getTransformerById(int id){
        String sql = "SELECT* FROM transformers WHERE id=?";
        Transformer transformer = new Transformer();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =  preparedStatement.executeQuery();

            resultSet.next();
            transformer.setId(Integer.parseInt(resultSet.getString(1)));
            transformer.setInputVoltage(resultSet.getInt(2));
            transformer.setOutputVoltage(resultSet.getInt(3));
            transformer.setOutputCurrent(resultSet.getInt(4));
            transformer.setMass(resultSet.getInt(5));
            transformer.setPrice(resultSet.getBigDecimal(6));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transformer;
    }

    public static List<Transformer> getTransformersList(){

        List<Transformer> transformersList = new ArrayList<>();
        String sql = "SELECT* FROM transformers;";

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                Transformer tmp = new Transformer();

                tmp.setId(Integer.parseInt(result.getString(1)));
                tmp.setInputVoltage(result.getInt(2));
                tmp.setOutputVoltage(result.getInt(3));
                tmp.setOutputCurrent(result.getInt(4));
                tmp.setMass(result.getInt(5));
                tmp.setPrice(result.getBigDecimal(6));

                transformersList.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transformersList;
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

