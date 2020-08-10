<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
  document.getElementById('date').value = new Date().toISOString().substring(0, 10);;
});
</script>
</head>
<body>
	<form>
		<h1>검색 페이지</h1>
		<input type="date" id="date" name="date"><span>~</span>
		<input type="date" id="date" name="date">
		<button id="datechoice">선택</button>
	</form>
	<div id="attendtable">
		<table>
			<tr>
				<th>날짜</th>
				<th>학번</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${list}" varStatus="status" var="bean">
			<tr>
				<td>${list.get(status.index).nalja }</td>
				<td>${list.get(status.index).num }</td>
				<td>${list.get(status.index).state }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>