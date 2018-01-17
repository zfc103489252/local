<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/16
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">
        .errorMessage li {
            list-style-type: none;
            width: 120px;
        }
        ul{
            padding:0;
            width: 120px;
            float: right;
        }
        div{
            width: 400px;
            height: 100px;
        }
    </style>
</head>
<body>
    <div style="width: 800px">
        <form action="register.action" method="post">
            <div>用户名：<input type="text" name="username"><s:fielderror fieldName="username"/></div>
            <br/>
            <div>密码：<input type="password" name="password"><s:fielderror fieldName="password"/></div><br/>
            <div>确认密码：<input type="password" name="passwords"><s:fielderror fieldName="passwords"/></div><br/>
            <div>手机号：<input type="number" name="phone"><s:fielderror fieldName="phone"/></div><br/>
            <div>邮箱：<input type="text" name="email"><s:fielderror fieldName="email"/></div><br/>
            <input style="background-color: #4d74ff" type="submit" value="注册"><br/>
            <a href="login.jsp">登录</a>
        </form>
    </div>
</body>
</html>
