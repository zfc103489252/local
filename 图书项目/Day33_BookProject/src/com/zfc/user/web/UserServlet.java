package com.zfc.user.web;

import com.zfc.cart.domain.Cart;
import com.zfc.user.dao.UserDao;
import com.zfc.user.domain.User;
import com.zfc.user.service.UserService;
import com.zfc.user.service.exception.login.NonactivatedException;
import com.zfc.user.service.exception.register.ExistException;
import com.zfc.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private User user = new User();
    List<Cart>cart = new ArrayList();
    UserService userService = new UserService();
    HttpSession session = null;
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            User login = userService.login(user);
            session = request.getSession();
            userService.session(session,login);
            session.setAttribute("car",cart);
            Cookie cookie = new Cookie("users",login.getUid());
            Cookie cookies = new Cookie("user",login.getUsername());
            cookie.setMaxAge(60*3);
            cookies.setMaxAge(60*3);
            response.addCookie(cookie);
            response.addCookie(cookies);
            return "l:/jsps/main.jsp";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NonactivatedException e) {
            System.out.println("帐号未激活异常");
        }
        return "l:/jsps/user/login.jsp";
    }

    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            userService.register(user);
            session =request.getSession();
            session.setAttribute("username",user.getUsername());
            return "r:/jsps/user/login.jsp";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("注册失败");
            e.printStackTrace();
        } catch (ExistException e) {
            System.out.println("存在异常");
            return "r:/jsps/user/login.jsp";
        }
        return "r:/jsps/user/regist.jsp";
    }
}
