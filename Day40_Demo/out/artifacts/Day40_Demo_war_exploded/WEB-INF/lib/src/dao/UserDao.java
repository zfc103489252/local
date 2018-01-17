package dao;

import doman.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3p0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = C3p0Util.getConnection();
    public User queryByUsername(User user){
        System.out.println(user.toString());
        String sql = "select * from zfc_user where username = ?";
        try {
            User query = qr.query(conn, sql, new BeanHandler<User>(User.class),user.getUsername());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(User user){
        String sql = "insert into zfc_user values(?,?,?,?)";
        try {
            User insert = qr.insert(conn, sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
