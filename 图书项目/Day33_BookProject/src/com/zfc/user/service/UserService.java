package com.zfc.user.service;

import com.zfc.user.dao.UserDao;
import com.zfc.user.domain.User;
import com.zfc.user.service.exception.login.NonactivatedException;
import com.zfc.user.service.exception.register.ExistException;
import com.zfc.util.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
import java.util.regex.Pattern;

public class UserService {
    UserDao userDao = new UserDao();
    public User login(User user) throws NonactivatedException {
        User lu = userDao.queryByUserName(user.getUsername());
        System.out.println(lu + "3");
        if (lu == null){
            System.out.println("账户不存在");
        }else if (!lu.getPassword().equals(user.getPassword())){
            System.out.println("密码错误");
        }
        if (lu.isState() == false){
            System.out.println("抛异常未激活激活码");
            throw new NonactivatedException();
        }
        return lu;
    }

    public void session(HttpSession session,User user){
        if (session.getAttribute("username") == null){
            session.setAttribute("username",user);
        }
    }

    public void register(User user) throws SQLException, ServletException, IOException, ExistException {
        User ru = userDao.queryByUserName(user.getUsername());
        EmailUtil emailUtil = new EmailUtil();
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        boolean isMatched;
        isMatched = Pattern.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",user.getEmail());
        if (ru != null){
            if (ru.getUsername().equals(user.getUsername())){
                System.out.println("账户已存在");
                throw new ExistException();
            }
            if (ru.getEmail().equals(user.getEmail())){
                System.out.println("邮箱已注册");
            }
        }else if (ru == null){
            if (isMatched == true){
                user.setUid(s);
                String code = emailUtil.email(user.getUid(), user.getEmail());
                user.setCode(code);
                if (user.getCode() != null){
                    userDao.insert(user);
                }else {
                    System.out.println("激活码为空");
                    return;
                }
            }else {
                System.out.println("邮箱格式错误");
                return;
            }
        }
    }

    public void state (String code) throws SQLException {
        User user = userDao.queryByCode(code);
        if (user != null){
            if (user.isState()==false){
                    userDao.status(user);
            }else {
                System.out.println("用户已经激活");
            }
        }else {
            System.out.println("无该用户");
        }
    }
}
