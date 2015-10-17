package nom.lesha.webApp01.dao;


import nom.lesha.webApp01.model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Alexey Levchenko
 */
public class ShopDao  /*extends ServletContextListener*/ /*extends HttpServlet*/ {

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

    public static boolean addItem(String name, String address, String tel, String workingTime){
        String sql = "INSERT INTO shops (name, address, tel, working_time) VALUES(?,?,?,?);";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2, address);
            statement.setString(3, tel);
            statement.setString(4, workingTime);

            if(statement.executeUpdate()>0){
                result=true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;
    }

    public static boolean addItem(Shop shop) {
        String sql = "INSERT INTO shops (name, address, tel, working_time) VALUES(?,?,?,?);";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,shop.getName());
            statement.setString(2, shop.getAddress());
            statement.setString(3, shop.getTel());
            statement.setString(4, shop.getWorkingTime());

            if(statement.executeUpdate()>0){
                result=true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;
    }

    public static boolean update(int id, String name, String address, String tel, String workingTime) {
        String sql = "UPDATE shops SET " +
                "name=?" +
                ",address=?" +
                ",tel=?" +
                ",working_time=?" +
                "WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,address);
            statement.setString(3,tel);
            statement.setString(4,workingTime);
            statement.setInt(5,id);
            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean update(Shop shop) {
        String sql = "UPDATE shops SET " +
                "name=?" +
                ",address=?" +
                ",tel=?" +
                ",working_time=?" +
                "WHERE id=?;";
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,shop.getName());
            statement.setString(2,shop.getAddress());
            statement.setString(3,shop.getTel());
            statement.setString(4,shop.getWorkingTime());
            statement.setInt(5,shop.getId());
            if(statement.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean delete(int id){
        String sql = "DELETE FROM shops WHERE id=?;";
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

    public static Shop getShopById(int id){
        String sql = "SELECT* FROM shops WHERE id=?";
        Shop shop = new Shop();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =  preparedStatement.executeQuery();

            resultSet.next();
            shop.setId(resultSet.getInt(1));
            shop.setName (resultSet.getString(2));
            shop.setAddress(resultSet.getString(3));
            shop.setTel(resultSet.getString(4));
            shop.setWorkingTime(resultSet.getString(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }

    public static List<Shop> getShopsList(){

        List<Shop> shopsList = new ArrayList<>();
        String sql = "SELECT* FROM shops;";

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                Shop tmp = new Shop();

                tmp.setId(result.getInt(1));
                tmp.setName (result.getString(2));
                tmp.setAddress(result.getString(3));
                tmp.setTel(result.getString(4));
                tmp.setWorkingTime(result.getString(5));

                shopsList.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopsList;
    }


}

