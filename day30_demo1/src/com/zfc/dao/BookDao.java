package com.zfc.dao;

import com.zfc.bean.Book;
import com.zfc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();
    public List<Book> qrBook(){
        String sql = "select * from book";
        Connection conn = null;
                conn=JdbcUtil.getConnection();
        try {
            List<Book> query = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            System.out.println(query);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
