package com.zfc.book.web;

import com.zfc.book.dao.BookDao;
import com.zfc.book.domain.Book;
import com.zfc.book.service.BookService;
import com.zfc.book.util.BsServlet;
import com.zfc.category.domain.Category;
import net.sf.json.JSONArray;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BsServlet {
    BookDao bookDao = new BookDao();
    List<Book> books = null;
    BookService bookService = new BookService();
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Category> a = bookDao.queryAllBookClass();
        HttpSession session = request.getSession();
        session.setAttribute("a",a);
        request.getRequestDispatcher("/jsps/left.jsp").forward(request,response);
    }

    public void queryClassify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String n = request.getParameter("name");
        books = bookService.queryClassifyBook(n);
        HttpSession session = request.getSession();
        session.setAttribute("books",books);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
    }

    public void queryParticular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("isd");
        Book book = bookDao.queryBybid(id);
        HttpSession session = request.getSession();
        session.setAttribute("bos",book);
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request,response);
//        response.sendRedirect("/jsps/book/desc.jsp");
    }


}
