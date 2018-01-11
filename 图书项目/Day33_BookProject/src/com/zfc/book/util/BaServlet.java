package com.zfc.book.util;

import com.zfc.book.domain.Book;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BaServlet",urlPatterns = "/bss")
public class BaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Object cla = request.getSession().getAttribute("cla");
        System.out.println(cla+"nini");
        JSONObject jsonObject = JSONObject.fromObject(cla);
        response.getWriter().write(jsonObject.toString());
        System.out.println(jsonObject.toString()+"ahahahhaa");
    }
}
