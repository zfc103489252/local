<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2017/12/28
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>访问获取信息</title>
  <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<button id="btn">点击获取信息</button>
<table border="1">
</table>
<form action="/ss" method="post">
  <label for="name">用户名：</label>
  <input id="name" type="text" name="name">
  <label for="gender">性别：</label>
  <input id="gender" type="text" name="gender">
  <label for="age">年龄：</label>
  <input id="age" type="text" name="age">
  <input type="submit">
</form>
</body>
<script type="text/javascript">
    $('#btn').click(function () {
        $('table tr').remove();
        $.get("/json",function (JsonData,status) {
            console.log(status);
            if (status == "success"){
                $('table').append(
                    $('<tr>').append(
                        $('<th>').text("id")
                    ).append(
                        $('<th>').text("姓名")
                    ).append(
                        $('<th>').text("性别")
                    ).append(
                        $('<th>').text("年龄")
                    )
                );
                var parseJSON = $.parseJSON(JsonData);
                $.each(parseJSON,function (index,obj) {
                    $('table').append(
                        $("<tr>").append(
                            $('<td>').text(obj['id'])
                        ).append(
                            $('<td>').text(obj['name'])
                        ).append(
                            $('<td>').text(obj['gender'])
                        ).append(
                            $('<td>').text(obj['age'])
                        )
                    )
                })
            }
        })
    })
</script>
</html>
