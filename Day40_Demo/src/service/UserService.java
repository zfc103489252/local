package service;

import action.RegisterAction;
import dao.UserDao;
import doman.User;

public class UserService {
    UserDao userDao = new UserDao();
    RegisterAction ra = new RegisterAction();
    public String register(User user){
        User u = userDao.queryByUsername(user);
        if (u != null){
            if (u.getUsername() != null){
                userDao.insertUser(user);
            }else {
                ra.addFieldError("username","用户名已存在");
                return "input";
            }
            return "success";
        }else {
            return "input";
        }
    }
}
