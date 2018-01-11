package com.zfc.user.dao;

import com.zfc.user.domain.User;
import com.zfc.util.C3p0Util;
import com.zfc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = JdbcUtil.getConnection();
    User user = new User();
    public User queryByUserName(String username){
        String sql = "select * from tb_user where username = ?";
        try {
            User query = qr.query(conn, sql, new BeanHandler<User>(User.class), username);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User queryByCode(String code){
        String sql = "select * from tb_user where code = ?";
        try {
            User query = qr.query(conn, sql, new BeanHandler<User>(User.class), code);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void insert(User user) throws SQLException {
        String sql = "insert into tb_user values(?,?,?,?,?,?)";
            qr.update(conn, sql,user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(),user.isState());
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void status(User user){
        String sql = "update tb_user set state = ? where code = ?";
        try {
            qr.update(conn,sql,true,user.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
