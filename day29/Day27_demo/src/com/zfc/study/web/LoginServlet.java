package com.zfc.study.web;

import com.zfc.study.dao.Tool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "com.zfc.LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        /**
         * Request:请求 包含这次请求的所有数据
         * Response:响应 将这次请求的结果返回给请求方
         */
        //使用req 获得请求参数
        //方法中传入的参数为：参数名 根据参数名获得参数值（类似键值对）
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //使用resp 将请求的结果返回给请求方
        response.getWriter().write("<h1>SUCCESS<h1>");
        try {
            int login = Tool.login(username, password);
            if (login == 2){
                response.setStatus(302);
                response.addHeader("location","http://localhost:8080/homepage.html");
            }else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.html");
                response.setContentType("text/html;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                requestDispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
