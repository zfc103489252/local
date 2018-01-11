package com.zfc.order.service;

import com.zfc.book.domain.Book;
import com.zfc.cart.domain.Cart;
import com.zfc.order.dao.OrderDao;
import com.zfc.order.domen.Order;
import com.zfc.order.domen.Orderitem;
import com.zfc.order.domen.Orders;
import com.zfc.user.domain.User;

import javax.servlet.http.Cookie;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderService {
    Order order = new Order();
    OrderDao orderDao = new OrderDao();
    public void add(Order order){
        orderDao.addOrder(order);
    }

    public String queryCookies(Cookie[] cookie){
        for (Cookie cookie1 : cookie) {
            if (cookie1.getName().equals("users")){
                return cookie1.getValue();
            }
        }
        return null;
    }

    public List<Order> queryByuid(User user){
        List<Order> orders = orderDao.queryByUidOrder(user);
        return orders;
    }

    public List<Orders> queryAll(String oid){
        List<Orders> show = orderDao.show(oid);
        return show;
    }


    //生成时间
    public String buttomTime(){
        //获取到点击的时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        return format;
    }

}
