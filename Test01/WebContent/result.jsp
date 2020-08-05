<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="list.bit">list.bit</a>
	<a href="attendance.jsp">attend.bit</a>


	<table>
		<tr>
			<td>num</td>
			<td>name</td>
			<td>att</td>
			<td>late</td>
			<td>absent</td>
		</tr>
		<c:forEach items="${alist }" varStatus="status" var="ele">
			<tr>
				<td>${alist.get(status.index).mnum }</td>
				<td>${alist.get(status.index).name }</td>
				<td>${alist.get(status.index).att }</td>
				<td>${alist.get(status.index).late }</td>
				<td>${alist.get(status.index).absent }</td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>