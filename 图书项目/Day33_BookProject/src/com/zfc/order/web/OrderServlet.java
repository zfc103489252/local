package com.zfc.order.web;

import com.zfc.book.domain.Book;
import com.zfc.book.service.BookService;
import com.zfc.book.util.BsServlet;
import com.zfc.cart.domain.Cart;
import com.zfc.order.domen.Order;
import com.zfc.order.domen.Orderitem;
import com.zfc.order.domen.Orderitemss;
import com.zfc.order.domen.Orders;
import com.zfc.order.service.OrderService;
import com.zfc.order.service.OrderitemService;
import com.zfc.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BsServlet {
    Order order = new Order();
    OrderService orderService = new OrderService();
    OrderitemService orderitemService = new OrderitemService();
    BookService bookService = new BookService();
    public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String uid = orderService.queryCookies(cookies);
        String price = request.getParameter("price");
        double d=Double.valueOf(price).doubleValue();
        List<Cart> o = (List<Cart>) session.getAttribute("car");
        order.setTotal(d);
        order.setUid(uid);
        order.setOrdertime(orderService.buttomTime());
        order.setOid(UUID.randomUUID().toString().replaceAll("-", ""));
        orderService.add(order);
        orderitemService.addOrderitem(o,order.getOid());
        session.setAttribute("order",order);
        List<Orders> list = orderService.queryAll(order.getOid());
        session.setAttribute("lis",list);
        o.clear();
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);
    }

    public void myOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User username = (User) session.getAttribute("username");
        List<Order> orders = orderService.queryByuid(username);
        List<Orderitemss> orderitems = orderitemService.queryByoid(username.getUid());
        System.out.println(orderitems+"sdksauhdksad");
        session.setAttribute("orderitemx",orderitems);
        session.setAttribute("myOrder",orders);
        request.getRequestDispatcher("jsps/order/list.jsp").forward(request,response);
    }
}
