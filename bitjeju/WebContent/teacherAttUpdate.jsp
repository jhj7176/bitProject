<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<c:set value="${bean }" var="bean" />
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$("input:radio[name=state][value=" + '<c:out value="${ bean.state }"/>' + "]").attr("checked","checked");	
});//상태 값 받아오기
</script>
</head>
<body>
	<h1>출석 수정</h1>
	<form action="lmsteacherattupdate.bit" method="post">
		<table>
		<tr>
			<th>날짜</th>
			<td>${bean.nalja }</td>
		</tr>
		<tr>
			<th>학번</th>
			<td>${bean.num }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${bean.name }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>
				<label for="ra">출석</label>
			    <input type="radio" class="state" name="state" value="출석">
			    <label for="ra">지각</label>
			    <input type="radio" class="state" name="state" value="지각">
			    <label for="ra">조퇴</label>
			    <input type="radio" class="state" name="state" value="조퇴">
			    <label for="ra">결석</label>
			    <input type="radio" class="state" name="state" value="결석">
			</td>
		</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>