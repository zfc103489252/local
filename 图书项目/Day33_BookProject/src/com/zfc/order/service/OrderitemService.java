package com.zfc.order.service;

import com.zfc.book.domain.Book;
import com.zfc.book.service.BookService;
import com.zfc.cart.domain.Cart;
import com.zfc.order.dao.OrderDao;
import com.zfc.order.dao.OrderitemDao;
import com.zfc.order.domen.Order;
import com.zfc.order.domen.Orderitem;
import com.zfc.order.domen.Orderitemss;
import com.zfc.order.domen.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderitemService {
    OrderDao orderDao = new OrderDao();
    Orderitem orderitem = new Orderitem();
    OrderitemDao orderitemDao = new OrderitemDao();
    BookService bookService = new BookService();
    public void addOrderitem(List<Cart> orderitems,String oid){
        for (int i = 0; i < orderitems.size(); i++) {
            orderitem.setIid(UUID.randomUUID().toString().replaceAll("-", ""));
            orderitem.setCount(orderitems.get(i).getCount());
            orderitem.setBid(orderitems.get(i).getBname().getBid());
            double s =Double.valueOf(orderitems.get(i).getBname().getPrice()).doubleValue();
            orderitem.setSubtotal(s);
            orderitem.setOid(oid);
            orderitemDao.addOrderitem(orderitem);
        }
    }

    public List<Orderitemss> queryByoid(String uid){

        List<Orderitemss> shows = orderDao.shows(uid);
        return shows;
    }

    public List<Book> queryBybids(List<Orderitem> orderitems){
        List<Book> books = new ArrayList<>();
        for (Orderitem orderitem1 : orderitems) {
            Book book = bookService.queryByBid(orderitem1.getBid());
            books.add(book);
        }
        return books;
    }
}
