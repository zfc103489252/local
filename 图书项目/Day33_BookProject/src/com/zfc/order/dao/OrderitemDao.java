package com.zfc.order.dao;

import com.zfc.order.domen.Order;
import com.zfc.order.domen.Orderitem;
import com.zfc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderitemDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = JdbcUtil.getConnection();
    public void addOrderitem(Orderitem orderitem){
        String sql = "insert into orderitem values(?,?,?,?,?)";
        try {
            qr.update(conn,sql,orderitem.getIid(),orderitem.getCount(),orderitem.getSubtotal(),orderitem.getOid(),orderitem.getBid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Orderitem queryByoid(String oid){
        String sql = "select * from orderitem where oid = ?";
        try {
            Orderitem query = qr.query(conn, sql, new BeanHandler<Orderitem>(Orderitem.class),oid);
            System.out.println(query+"sadsadqwdd");
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
