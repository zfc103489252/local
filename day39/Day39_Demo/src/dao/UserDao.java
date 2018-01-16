package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3p0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    QueryRunner qr  = new QueryRunner();
    Connection conn = C3p0Util.getConnection();
    public void insert(User user){
        String sql = "insert into zfc_user values(?,?)";
        try {
            User insert = qr.insert(conn, sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User queryByUsername(String username){
        String sql = "select * from zfc_user where username= ?";
        try {
            User query = qr.query(conn, sql, new BeanHandler<User>(User.class),username);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
