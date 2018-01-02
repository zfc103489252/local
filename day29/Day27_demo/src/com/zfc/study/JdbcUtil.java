package com.zfc.study;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    static {
        try {
            ClassLoader cl = JdbcUtil.class.getClassLoader();
            InputStream inputStream = cl.getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            database = properties.getProperty("database");
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("路径出错");
            e.printStackTrace();
        }
    }
    private static String database;
    private static String password;
    private static String user;
    private static String url;

    public static Connection getC(){
        try {
            Connection connection = DriverManager.getConnection(url+database,user,password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
