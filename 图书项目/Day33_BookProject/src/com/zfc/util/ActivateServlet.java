package com.zfc.util;

import com.zfc.user.dao.UserDao;
import com.zfc.user.domain.User;
import com.zfc.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ActivateServlet",urlPatterns = "/activate")
public class ActivateServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String cc = request.getParameter("cc");
        try {
            userService.state(cc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("激活成功");
        request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
