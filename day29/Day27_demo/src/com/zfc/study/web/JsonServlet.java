package com.zfc.study.web;

import com.zfc.study.dao.User;
import com.zfc.study.dao.UserDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JsonServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        try {
            List<User> sc = UserDao.sc();
            JSONArray jsonArray = JSONArray.fromObject(sc);
            System.out.println(jsonArray.toString());
            resp.getWriter().write(jsonArray.toString());
            } catch (SQLException e1) {
            e1.printStackTrace();
        }

        // 指定允许其他域名访问
        resp.addHeader("Access-Control-Allow-Origin","*");
        // 响应类型
        resp.addHeader("Access-Control-Allow-Methods","POST");
        // 响应头设置
        resp.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");


    }
}
