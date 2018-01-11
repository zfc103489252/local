package com.zfc.order.dao;

import com.zfc.cart.domain.Cart;
import com.zfc.order.domen.Order;
import com.zfc.order.domen.Orderitem;
import com.zfc.order.domen.Orderitemss;
import com.zfc.order.domen.Orders;
import com.zfc.user.domain.User;
import com.zfc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = JdbcUtil.getConnection();
    public void addOrder(Order order){
        String sql = "insert into orders values(?,?,?,?,?,?)";
        try {
            qr.update(conn,sql,
                    order.getOid(),
                    order.getOrdertime(),
                    order.getTotal(),
                    order.getState(),
                    order.getUid(),
                    order.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> queryByUidOrder(User user){
        String sql = "select * from orders where uid = ?";
        try {
            List<Order> query = qr.query(conn, sql, new BeanListHandler<Order>(Order.class), user.getUid());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Orders> show(String oid){
        List<Orders> carts = null;
        try {
            carts = qr.query(conn,
                    "SELECT r.count, b. * FROM orders o INNER JOIN orderitem r" +
                            " ON o.oid = r.oid INNER JOIN book b ON r.bid = b.bid" +
                            " WHERE o.oid =?",
                    new BeanListHandler<Orders>(Orders.class),oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }

    public List<Orderitemss> shows(String uid){
        List<Orderitemss> carts = null;
        try {
            carts = qr.query(conn,
                    "SELECT b.*,COUNT,o2.oid,o2.ordertime,o2.total FROM book b INNER JOIN orderitem o1 ON b.bid = o1.bid INNER JOIN orders o2 ON o2.oid = o1.oid WHERE o2.uid = ?",
                    new BeanListHandler<Orderitemss>(Orderitemss.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }
}
