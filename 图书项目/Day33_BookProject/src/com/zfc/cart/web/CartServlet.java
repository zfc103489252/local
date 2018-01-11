package com.zfc.cart.web;

import com.zfc.book.domain.Book;
import com.zfc.book.service.BookService;
import com.zfc.book.util.BaServlet;
import com.zfc.book.util.BsServlet;
import com.zfc.cart.domain.Cart;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BsServlet{
    BookService bookService = new BookService();
    Cart cart = null;
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        String counts = request.getParameter("count");
        int count = Integer.parseInt(counts);
        Book book = bookService.queryByBid(bid);
        HttpSession session = request.getSession();
        List<Cart> list = (List<Cart>)session.getAttribute("car");
        cart = new Cart(count,book);
        list.add(cart);
        request.getSession().setAttribute("car",list);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);

    }

    public void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Cart> car = (List<Cart>) session.getAttribute("car");
        car.clear();
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        HttpSession session = request.getSession();
        List<Cart> car = (List<Cart>) session.getAttribute("car");
        List<Cart> list = bookService.deleteByBid(car, bid);
        session.setAttribute("car",list);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
    }
}
