<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="login" method="post">
        姓名：<input name="username">
        密码：<input name="password">
        <input type="submit" value="登录">
    </form>
    <a href="register.jsp">注册</a>
</body>
</html>
