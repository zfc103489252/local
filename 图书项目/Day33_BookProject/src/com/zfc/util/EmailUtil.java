package com.zfc.util;

import com.zfc.user.domain.User;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public class EmailUtil {
    private String sendAddr = "zll103489252";//这是发送方的邮箱
    //这个不是密码,是开启163邮箱第三方登录时候设置的授权码
    //如果不开启,那么是无法第三方登录163邮箱账号的
    private String pass = "spbmxvlueeadcafb";
    User user = new User();
    public String email(String uid,String email) throws ServletException, IOException {
        String receiveAddr = email;//接收方的邮箱
//        String receiveAddr = "1353251258@qq.com";
        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.port","587");
        //我们要登录一个账号,来给别人发邮件
        //现在先构建一个邮件账号，需要用邮件地址和密码
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddr+"@qq.com",pass);
            }
        };

        //与服务器连接,这时候就连上了163.com的服务器
        //实际上就是用java代码,登录了自己的163邮箱
        Session session = Session.getInstance(prop,auth);

        //创建一个邮件对象
        //这就是登录了邮箱之后,点击了发邮件,进入编辑邮件的窗口
        MimeMessage msg = new MimeMessage(session);

        //设置发件人
        try {
            msg.setFrom(new InternetAddress(sendAddr+"@qq.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置收件人
        try {
            msg.setRecipients(Message.RecipientType.TO,receiveAddr);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置抄送
//		msg.setRecipients(Message.RecipientType.CC,"抄送人@163.com");

        //设置密送
        //一封邮件发给了a,b,c三个人,a是可以知道这封邮件也发给了b,c的
        //如果设置了密送给d,那么a,b,c是不知道这封邮件也发给了d的
//		msg.setRecipients(Message.RecipientType.BCC,"偷偷的发@163.com");

        //添加主题
        try {
            msg.setSubject("激活码");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //添加内容,第二个参数表示这是html的内容
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        user.setCode(uid+s);
        try {
            msg.setContent("激活码："+user.getCode()+"<a href= \"http://192.168.20.197:8080/jsps/msg.jsp\">激活页面</a>","text/html;charset=utf-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return user.getCode();
    }
}
