package com.zfc.study.dao;

import com.zfc.study.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public static List<User> sc() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from zfc_user";
        List<User> query = qr.query(JdbcUtil.getC(), sql, new BeanListHandler<User>(User.class));
        return query;
    }
}
