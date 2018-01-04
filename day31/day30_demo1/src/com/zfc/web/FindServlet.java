package com.zfc.web;

import com.zfc.bean.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindServlet",urlPatterns = "/find")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User u = (User) getServletContext().getAttribute("user");
        JSONArray jsonArray = JSONArray.fromObject(u);
        response.getWriter().write(jsonArray.toString());
        // 指定允许其他域名访问
        response.addHeader("Access-Control-Allow-Origin","*");
        // 响应类型
        response.addHeader("Access-Control-Allow-Methods","POST");
        // 响应头设置
        response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
    }

}
