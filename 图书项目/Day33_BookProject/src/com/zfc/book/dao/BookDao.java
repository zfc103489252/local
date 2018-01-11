package com.zfc.book.dao;

import com.zfc.book.domain.Book;
import com.zfc.category.domain.Category;
import com.zfc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = JdbcUtil.getConnection();
    Category category = new Category();
    public List<Category> queryAllBookClass(){
        String sql = "select * from category";
        try {
            List<Category> s = qr.query(conn, sql, new BeanListHandler<Category>(Category.class));
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> queryClassifyBook(Category category){
        String sql = "select * from book where cid = (select cid from category where cname = ?)";
        try {
            List<Book> query = qr.query(conn, sql, new BeanListHandler<Book>(Book.class),category.getCname());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> queryAllifyBook(){
        String sql = "select * from book";
        try {
            List<Book> query = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book queryBybid(String id){
        String sql = "select * from book where bid = ?";
        try {
            Book query = qr.query(conn, sql, new BeanHandler<Book>(Book.class),id);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
