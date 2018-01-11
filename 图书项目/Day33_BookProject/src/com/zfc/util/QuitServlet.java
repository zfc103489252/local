package com.zfc.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "QuitServlet",urlPatterns = "/quit")
public class QuitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
//        request.getRequestDispatcher("/msg.jsp");
        response.setStatus(302);
        response.addHeader("location","http://localhost:8080/jsps/user/login.jsp");
    }
}
