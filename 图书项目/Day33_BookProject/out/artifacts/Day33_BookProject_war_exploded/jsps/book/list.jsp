<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    <%--<script src="/js/jquery-3.2.1.min.js"></script>--%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	div {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>

  <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/8758723-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
  <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/9265169-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/20029394-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/20385925-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/22722790-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/22788412-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
  <%--</div>--%>

  <%--<a href="<c:url value='/book?methods=queryClassify&name=se'/>">JavaSE分类</a>--%>
  <c:if test="${sessionScope.books!=null}">
      <c:forEach items="${sessionScope.books}" var="book">
          <d>
              <div>
                  <a href="<c:url value='/book?methods=queryParticular&isd=${book.bid}'/> "><img src="<c:url value='${book.image}'/>"></a>
                  <br>
                  <a href="<c:url value='/book?methods=queryParticular&isd=${book.bid}'/>">${book.bname}</a>
              </div>
          </d>
      </c:forEach>
  </c:if>


  </body>
  <%--<script type="text/javascript">--%>
      <%--$.getJSON("<c:url value='/book'/> ",function (data,status) {--%>
          <%--var bookJSON = $.parseJSON(data);--%>
          <%--console.log(data);--%>
          <%--console.log(status);--%>
<%--//          $('body>div').remove();--%>
          <%--$.each(bookJSON,function (index, book) {--%>
              <%--if (book['bname']!=null){--%>
                  <%--$('body').append($('<div>').attr("class","icon")--%>
                      <%--.append($('<a href="<c:url value='/jsps/book/desc.jsp'/>">'))--%>
                      <%--.append($('<img border="0"/>').attr("src","../../"+book['image']))--%>
                      <%--.append($('<br>'))--%>
                      <%--.append($('<a href="<c:url value='/jsps/book/desc.jsp'/>">'))--%>
                      <%--.append($('<a href="<c:url value='/jsps/book/desc.jsp'/>">').text(book['bname'])))--%>
              <%--}--%>
          <%--})--%>
      <%--})--%>

  <%--</script>--%>
</html>

