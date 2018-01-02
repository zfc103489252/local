package com.zfc.study.dao;

import com.zfc.study.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Tool {
    public static int register(String username,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day29" + "?user=root&password=123");
        Statement statement = connection.createStatement();
//        System.out.println(person.getName());
        System.out.println(username);
        int i = statement.executeUpdate("INSERT INTO zfc_user" + " VALUE (NULL,'" + username + "' ,'" + password + "')");
        statement.close();
        connection.close();
        return i;
    }

    public static int login(String userName, String password) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from zfc_user";
        List<User> query = qr.query(JdbcUtil.getC(), sql, new BeanListHandler<User>(User.class));
        System.out.println(query);
        for (User user : query) {
            if (user.getUsername().equals(userName)&&!user.getPassword().equals(password)){
                return 1;
            }
            if (user.getUsername().equals(userName)&&user.getPassword().equals(password)){
                System.out.println("登陆成功 \n"+user.toString());
                return 2;
            }
        }
        return 0;
    }

}
