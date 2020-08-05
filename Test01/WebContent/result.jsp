<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


table{
width:400px;
	border:1px solid;
	border-collapse: collapse;
}
tr{
	text-align:center;
	padding:10px;
}
th{
	border:1px solid;	
}

</style>
</head>
<body>

	<a href="list.bit">list.bit</a>
	<a href="attendance.jsp">attend.bit</a>


	<table>
		<tr>
			<th>학번</th>
			<th width="100px">날짜</th>
			<th>출석정보</th>
			<th>출석</th>
			<th>지각</th>
			<th>결석</th>
		</tr>
		<c:forEach items="${alist }" varStatus="status" var="ele">
			<tr>
				<td>${alist.get(status.index).mnum }</td>
				<td>${alist.get(status.index).attdate }</td>
				<td>${alist.get(status.index).attendance }</td>
				<td>${alist.get(status.index).att }</td>
				<td>${alist.get(status.index).late }</td>
				<td>${alist.get(status.index).absent }</td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>