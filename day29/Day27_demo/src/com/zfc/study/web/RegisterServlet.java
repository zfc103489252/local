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

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=utf-8");
      req.setCharacterEncoding("utf-8");
        /**
         * Request:请求 包含这次请求的所有数据
         * Response:响应 将这次请求的结果返回给请求方
         */
        //使用req 获得请求参数
        //方法中传入的参数为：参数名 根据参数名获得参数值（类似键值对）
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("已经访问到Servlet");

        //使用resp 将请求的结果返回给请求方
        resp.getWriter().write("<h1>SUCCESS<h1>");
        try {
            int register = Tool.register(username, password);
            if (register == 1){
                resp.setStatus(302);
                resp.addHeader("location","http://localhost:8080/login.html");
            }else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://localhost:8080/register.html");
                requestDispatcher.forward(req,resp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
