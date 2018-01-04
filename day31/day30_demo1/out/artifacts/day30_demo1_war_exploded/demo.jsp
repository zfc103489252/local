<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/4
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name="";
    String psw="";
    String checked="";
    Cookie[] cookies=request.getCookies();
    if(cookies!=null&&cookies.length>0){
        //遍历Cookie
        for(int i=0;i<cookies.length;i++){
            Cookie cookie=cookies[i];
            //此处类似与Map有name和value两个字段,name相等才赋值,并处理编码问题
            if("name".equals(cookie.getName())){
                name= URLDecoder.decode(cookie.getValue(),"utf-8");
                //将"记住我"设置为勾选
//                checked="checked";
            }
            if("psw".equals(cookie.getName())){
                psw=cookie.getValue();
            }
        }
    }
%>
<TR>
    <TD class="td">用户帐号：</TD>
    <TD class="td"><input name="name" type="text" value="<%=name %>" id="name"/></TD>
</TR>
<TR>
    <TD class="td">登录密码：</TD>
    <TD class="td"><input name="password" type="password" value="<%=psw %>" id="password"></TD>
</TR>
<TR>
    <%--<TD class="td">记住我：</TD>--%>
    <%--<TD class="td"><input name="rememberMe" type="checkbox" id="rememberMe" class="checkbox" <%=checked %>></TD>--%>
</TR>
</body>
</html>
