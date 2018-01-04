package com.zfc.web;

import com.zfc.bean.User;
import com.zfc.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
            User user1 = userDao.queryByUsername(user.getUsername());
            if (user1 != null){
                if (user.getUsername().equals(user1.getUsername())){
                    if (user.getPassword().equals(user1.getPassword())){
                        System.out.println("登录成功");
                        //存到ServletContext中
                        getServletContext().setAttribute("user",user);
                        HttpSession session = request.getSession();
                        session.setAttribute("username",user.getUsername());
//                        Cookie[] cookies = request.getCookies();
//                        for (Cookie cookie1 : cookies) {
//                            System.out.println(cookie1.getName()+ "=" +cookie1.getValue()+"111");
//                        }
                        Cookie cookie = new Cookie("users",user.getUsername());
                        cookie.setPath("/login.jsp");
                        cookie.setMaxAge(60*3);
                        response.addCookie(cookie);
                        response.setStatus(302);
                        response.addHeader("location","http://localhost:8080/index.jsp");
                        return;
                    }
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                    System.out.println("密码错误");
                }else {
                    request.getRequestDispatcher("/register.html").forward(request,response);
                    System.out.println("登录失败");
                }
            }else {
                System.out.println("账户不存在");
                request.getRequestDispatcher("/register.html").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
