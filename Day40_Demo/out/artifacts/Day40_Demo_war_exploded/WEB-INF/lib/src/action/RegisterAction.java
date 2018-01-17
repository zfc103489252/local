package action;

import com.mchange.lang.IntegerUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import doman.User;
import org.apache.commons.lang3.StringUtils;
import service.UserService;

public class RegisterAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();
//    UserService userService = new UserService();

    public String register(){
//        String register = userService.register(user);
        return "input";
    }

    @Override
    public void validate() {
        if (StringUtils.isBlank(user.getUsername())){
            System.out.println("111");
            addFieldError("username","用户名不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())){
            addFieldError("password","密码不能为空");
        }
        if (StringUtils.isBlank(user.getPasswords())){
            addFieldError("passwords","确认密码不能为空");
        }
        if (StringUtils.isBlank(user.getPhone())){
            this.addFieldError("phone","手机号不能为空");
        }
        if (StringUtils.isBlank(user.getEmail())){
            addFieldError("email","邮箱不能为空");
        }
        super.validate();
    }

    @Override
    public User getModel() {
        return user;
    }
//    public User getUser(){
//        return user;
//    }
}
