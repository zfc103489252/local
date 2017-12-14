package zcdl;

import org.dom4j.DocumentException;
import zcdl.document.Documents;
import zcdl.exception.LoginException;
import zcdl.rexception.RegisterException;
import zcdl.rexception.UsException1;
import zcdl.tool.PasswordTool;
import zcdl.tool.UserNameTool;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String userName = null;
    public static String password = null;
    public static void main(String[] args) throws IOException, DocumentException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1注册 2登录");
            int a = input.nextInt();
            input.nextLine();
            switch (a) {
                case 1:
                    System.out.println("输出姓名：");
                    String name = input.nextLine();
                    imp(input);
                    Person person = new Person(name,userName, password);
                    if (Documents.document != null) {
                        try {
                            Register.register(person);
                        } catch (UsException1 usException1) {
                            System.out.println(usException1.getMessage());
                            continue;
                        }
                    }
                    try {
                        UserNameTool.us(userName);
                    } catch (RegisterException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    try {
                        PasswordTool.ps(password);
                    } catch (RegisterException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    Documents.register(person);
                    System.out.println("注册成功");
                    break;
                case 2:
                    imp(input);
                    if (Documents.document != null){
                        try {
                            Login.login(userName,password);
                        } catch (LoginException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                    }else {
                        System.out.println("傻逼你没注册");
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static void imp(Scanner input){
        System.out.println("输入用户名");
        userName = input.nextLine();
        System.out.println("输入密码");
        password = input.nextLine();
    }
}
