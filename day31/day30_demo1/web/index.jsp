<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js">

    </script>
  </head>
  <body>
  <%
    if (session.getAttribute("username") != null){
        %>
            <h1>登陆成功</h1>
            <table id="a" border="1"></table>
            <table id="b" border="1"></table>
            <a href="http://localhost:8080/quit" id="but" name="sss">退出</a>
        <%
    }else {
        %>
            <h1><a href="login.jsp">请登录</a></h1>
        <%
    }
  %>
  </body>
<script type="text/javascript">
  $.getJSON("http://localhost:8080/find",function (json,status) {
      if (status == "success"){
          $('#a').append(
              $('<tr>').append(
                  $('<th>').text("姓名")
              ).append(
                  $('<th>').text("密码")
              )
          );
         $.each(json,function (index, obj) {
             var username = obj['username'];
             var password = obj['password'];
            $('#a').append(
                $('<tr>')
            .append(
                $('<td>').text(username)
            ).append(
                $('<td>').text(password)
            )
         )
         })
      }

  })
  $.getJSON("http://localhost:8080/book",function (json,status) {
      if (status == "success"){
          $('#b').append(
              $('<tr>').append(
                  $('<th>').text("书名")
              ).append(
                  $('<th>').text("作者")
              ).append(
                  $('<th>').text("价钱")
              )
          );
          $.each(json,function (index, obj) {
              var bookname = obj['bookname'];
              var writer = obj['writer'];
              var price = obj['price'];
              $('#b').append(
                  $('<tr>')
                      .append(
                          $('<td>').text(bookname)
                      ).append(
                      $('<td>').text(writer)
                      ).append(
                      $('<td>').text(price)
                      )
              )
          })
      }

  })

</script>
</html>
