package service;

import dao.UserDao;
import domain.User;

public class UserService {
    UserDao userDao = new UserDao();
    public void register(User user) {
        User user1 = userDao.queryByUsername(user.getUsername());
        if (user1 != null){
            System.out.println("抛异常用户已存在");
            return;
        }else {
            userDao.insert(user);
            System.out.println("注册成功");
        }
    }

    public void login(User user){
        User user1 = userDao.queryByUsername(user.getUsername());
        if (!user.getPassword().equals(user1.getPassword())){
            System.out.println("抛异常密码不正常");
        }else {
            System.out.println("登陆成功");
        }
    }
}
