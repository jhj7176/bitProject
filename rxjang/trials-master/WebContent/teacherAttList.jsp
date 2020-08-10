<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta charset="UTF-8">
<%@ include file="template/lmshead.jspf" %>
<title>BITCAMP JEJU: LMS강사-출석조회</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){

});
</script>
</head>
<body>
<%@ include file="template/lmsheader.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="contents">
   <!--*****************lms메뉴******************-->
       <div class="grid2">
        <div id="lmsmenu">
            <p>강사</p>
            <ul>
                <li class="bigletter">출결관리</li>
                <li>
                    <a href="lmsteacherattendance.bit">출석체크</a>    
                </li>
                <li>
                    <a href="lmsteacherattlist.bit">출석조회</a>    
                </li>
                <li class="bigletter">수강생관리</li>
                <li>
                    <a href="#">수강생정보</a>    
                </li>
                <li>
                    <a href="#">성적입력</a>    
                </li>
                <li>
                    <a href="#" class="bigletter">자료실</a>    
                </li>
                <li></li>
            </ul>
        </div>
       </div>
        <!--*****************lms메뉴******************-->
       <div  id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
	<h1>출석조회</h1>
	<form action="lmsteacherattsearch.bit" method="post">
		<input type="date" class="date" name="nalja1"><span>~</span>
		<input type="date" class="date" name="nalja2">
		<button id="datechoice">선택</button>
	</form>
	<div id="attendtable">
		<table>
			<tr>
				<th>날짜</th>
				<th>이름</th>
				<th>학번</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${list}" var="bean">
			<tr>
				<td>${bean.nalja }</td>
				<td>${bean.num }</td>
				<td>${bean.name }</td>
				<td>${bean.state }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	 <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
</body>
</html>