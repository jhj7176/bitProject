<%@page import="com.bitjeju.customer.model.NoticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/head.jspf" %>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
	dl{
		border:1px solid gray;
		width: 800px;
		margin: 1px auto;
		text-align: center;
	}
	dl>dt,dl>dd,dl>dd>div{
		display: inline-block;
		margin-left: auto;
	}
	dl>dt{
		width: 100px;
	}
	dl>dd{
		width: 600px;
	}
	dl>dd>div{
		 padding-left: 155px;
	}
	.table_main{
		margin-top: 30px;
	}
	.search{
		padding-left: 300px;
	}
	#footer{
		margin-top: -400px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="template/header.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="contents">
       <!--*****************비트캠프 메뉴******************-->
   	<div class="grid2">
        <div id="menuer">
        </div>
       </div>
        <!--*****************비트캠프 메뉴******************-->
       <div  id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
       
       
       <img alt="" src="img/2.jpg"/>
       
       	<h3>공지사항</h3>
       	<div class="table_main">
 		<dl>
 			<dt>번호</dt>
 			<dd>
 				<div>제목</div>
 				<div>작성자</div>
 				<div>날짜</div>
 			</dd>
 		</dl>
 		<%-- <%
 			ArrayList<Board2Dto> list = (ArrayList<Board2Dto>)request.getAttribute("alist");
 			for(Board2Dto bean:list){
 		%>
 		<dl>
 			<dt><%=bean.getNum() %></dt>
 			<dd>
 				<div><%=bean.getTitle() %></div>
 				<div><%=bean.getWriter() %></div>
 				<div><%=bean.getWtime() %></div>
 			</dd>
 		</dl>
 		
 		<%} %> --%>
 	
 		<form action="">
 			<div class="search">
 				<select name="search">
 				<option value="0">===선택===</option>
 				<option value="1" selected>제목</option>
 				<option value="2">내용</option>
 				<option value="3">작성자</option>
 				<option value="4">제목+내용</option>
 				</select>
 				<input type="text" name="searchWord" id="searchWord"/>
 				<button type="submit" value="search">검색</button>
 				<a href="detail.bit">입력</a>
 			</div>
 		</form>
 		</div>
       <!--*************content end******************-->
       </div>
<%@ include file="template/footer.jspf" %>
</body>
</html>