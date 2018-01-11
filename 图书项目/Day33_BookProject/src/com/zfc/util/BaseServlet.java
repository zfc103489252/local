package com.zfc.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("method");
        Class<? extends BaseServlet> aClass = this.getClass();
        Method method = null;
        try {
            method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            String invoke = (String)method.invoke(this, request, response);
            String[] split = invoke.split(":");
            String s = split[0];
            String s1 = split[1];
            if (s.equals("l")){
                request.getRequestDispatcher(s1).forward(request,response);
            }
            if (s.equals("r")){
                response.sendRedirect(request.getContextPath()+s1);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
