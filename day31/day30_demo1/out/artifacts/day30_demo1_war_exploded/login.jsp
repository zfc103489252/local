<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Arrays" %><%--
Created by IntelliJ IDEA.
User: lanou
Date: 2018/1/4
Time: 20:08
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <style type="text/css">
        .s{
            position: absolute;
            top: 0px;
            left: 0px;
            background-color: mintcream;
            width: 100%;
            height: 70px;
        }
        .s1{
            width: 300px;
            height: 70px;
            position: absolute;
            background-color: mintcream;
        }
        .s2{
            width: 120px;
            height: 70px;
            position: absolute;
            right: 60px;
        }
        .s3{
            position:absolute;
            bottom: 20px;
            right: 0px;
            width: 120px;
            height: 30px;
        }
        .s4{
            position: absolute;
            right: 20px;
            top: 25px;
        }
        .s5{
            width: 300px;
            height: 70px;
            position: absolute;
        }
        .s6{
            position: absolute;
            top: 25px;
            left: 20px;
            text-decoration: none;
        }
        .s7{
            position: absolute;
            top: 25px;
            left: 120px;
            text-decoration: none;
        }
        .s8{
            position: absolute;
            top: 25px;
            left: 110px;
        }
        .s9{
            height: 900px;
            width: 100%;
            position: absolute;
            top: 70px;
            background-color: aliceblue;
        }
        .s10{
            width: 480px;
            height: 580px;
            position: absolute;
        }
        .s11{
            width: 400px;
            height: 80px;
            position: absolute;
            border: solid 1px #b2b6b9;
        }
        .s12{
            width: 320px;
            height: 40px;
            position: absolute;
            right: 15px;
            top: 20px;
        }
        .s13{
            width: 250px;
            height: 40px;
            position: absolute;
            left: 10px;
            top: 5px;
            border: 0px;
        }
        .s14{
            position: absolute;
            left: 20px;
            top: 25px;
        }
        .img{
            width: 40px;
            height: 40px
        }
        .s15{
            width: 400px;
            height: 25px;
            background-color: #fffdff;
            position: absolute;
            left: 40px;
            top: 380px;
        }
        .s16{
            width: 200px;
            height: 25px;
            position: absolute;
        }
        .s17{
            position: absolute;
            top: 0px;
            left: 100px;
        }
        .s18{
            background-color: mintcream;
            width: 400px;
            height: 80px;
            position: absolute;
            left: 40px;
            top: 420px;
        }
        .but{
            width: 400px;
            height: 60px;
            position: absolute;
            top: 10px;
            background-color: #3263ed;
        }
        .s19{
            width: 400px;
            height: 20px;
            background-color: aliceblue;
            position: absolute;
            left: 40px;
            top: 510px;
        }
        .z{
            position: absolute;
            top: 0px;
            right: 0px;
        }


    </style>
</head>
<body>

<%
    String name="";
    Cookie[] cookies=request.getCookies();
    for (Cookie cookie : cookies) {
        if("users".equals(cookie.getName())){
            name= URLDecoder.decode(cookie.getValue(),"utf-8");
        }
    }

%>
    <div style="height: 1000px;width: 100%;position: fixed">
        <div class="s">
            <div class="s1">
                <a href="" class="s2">
                    <img src="img/logo@2x.png" class="s3">
                </a>
                <div class="s4">登录</div>
            </div>
            <div class="z s5">
                <a href="" class="s6">网易云首页</a>
                <span class="s8">|</span>
                <a href="" class="s7">帮助与文档</a>
            </div>
            <div class="s5">
                <p id="demo"></p>
            </div>
        </div>
        <div class="s9">
            <div style="height: 600px;width: 80%;position: absolute;top: 100px;left: 10%">
                <form style="right: 10%;top: 10px;background-color: mintcream" class="s10" action="/login" method="post">
                    <h2 style="text-align: center">网易云登录</h2>
                    <div style="left: 40px;top: 80px;" class="s11">
                        <div class="s12">
                            <input id="z" name="username" value="<%=name %>" onfocus="inputFocus(this)" onblur="inputBlur(this)" class="s13" type="text" placeholder="网易云帐号/网易云邮箱帐号">
                        </div>
                        <i class="s14"><img class="img" src="img/用户.png"></i>
                    </div>
                    <div style="left: 40px;top: 200px;" class="s11">
                        <div class="s12">
                            <input id="zz" name="password" onfocus="inputFocus2(this)" onblur="inputBlur2(this)" class="s13" type="text" placeholder="登录密码">
                        </div>
                        <i class="s14"><img class="img" src="img/密码.png"></i>
                    </div>
                    <div class="s15">
                        <div style="left: 3px" class="s16">
                            <div><input type="checkbox"><span>遵守并同意</span></div>
                            <a href="" class="s17">《服务条款》</a>
                        </div>
                        <div style="width: 120px;right: 3px" class="s16">
                            <input type="checkbox"><span>15天免登录</span>
                        </div>
                    </div>
                    <div class="s18">
                        <button class="but" id="d" onfocus="inputFocus1(this)">登         录</button>
                    </div>
                    <div class="s19">
                        <div style="width: 200px;height: 20px;position: absolute;left: 3px">
                            <div><span>还没有帐号？</span></div>
                            <a href="register.html" style="position: absolute;top: 0px;left: 100px">免费注册</a>
                        </div>
                        <div style="width: 160px;height: 20px;position: absolute;right: 3px">
                            <a href="" style="position: absolute;top: 0px;left: 80px">忘记密码？</a>
                        </div>
                    </div>
                </form>
                <div style="left: 10%;top: 10px" class="s10">
                    <div style="position: absolute;top: 10px;left: 10px">
                        <img src="img/login-image6.png" style="width: 460px;height: 520px">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
    <script type="text/javascript">
        function inputFocus1() {
            var d1 = document.getElementById("d");
            d1.style.backgroundColor = "red";
        }

        function inputFocus() {
            var z = document.getElementById("z");
            z.style.border = "1px solid red";
//            z.style.borderColor = "red";
            z.style.fontSize = "25px";
        }
        function inputBlur() {
            var z1 = document.getElementById("z");
            z1.style.fontSize = "15px";
            z1.style.border = "0px";
        }
        function inputFocus2() {
            var z = document.getElementById("zz");
            z.style.border = "1px solid red";
//            z.style.borderColor = "red";
            z.style.fontSize = "25px";
        }
        function inputBlur2() {
            var z1 = document.getElementById("zz");
            z1.style.fontSize = "15px";
            z1.style.border = "0px";
        }
        setInterval(function(){myTimer()},1000);
        function myTimer()
        {
            var d=new Date();
            var t=d.toLocaleTimeString();
            document.getElementById("demo").innerHTML=t;
        }
    </script>
</html>