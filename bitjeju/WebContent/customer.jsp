
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf"%>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
#content {
	height: 800px;
}

.title_bar { /* 국비지원 */
	background-color: darkblue;
	width: 4px;
	height: 19px;
	display: inline-block;
	margin-left: 60px;
	vertical-align: middle;
}

.title_letter {
	color: darkblue;
	font-size: 18px;
	font-weight: 600;
	display: inline;
	vertical-align: middle;
}

.notice-div {
	margin-top: 25px;
}

#notice-table {
	margin: auto;
	width: 700px;
	border-collapse: collapse;
	border-bottom: 1px solid #e4e4e4;
	border-top: 1px solid #e4e4e4;
	margin-bottom: 10px;
}

#notice-table tr {
	text-align: center;
}

#notice-table tr:first-child ~tr:hover { /* 테이블 첫번째 tr빼고 hover적용  */
	color: #1E3269;
	background-color: aliceblue;
}

#notice-table th {
	color: #1E3269;
	padding: 20px;
	border-bottom: 1px solid #e4e4e4;
}

#notice-table td {
	padding: 25px;
}




#search-div { /*검색창 감싸는 Div  */
	display: block;
	margin: auto;
	clear: both;
	width: 440px;
	margin-bottom:300px;
}


#searchbtn {
	float: right;
	background-color: #000069;
	border: 1px solid #000069;
	border-radius: 5px;
	color: white;
	margin: 7px;
	width: 50px;
	line-height:30px;
	vertical-align:middle;
}

#searchbtn:hover {
	background-color: white;
	color: #000069;
	cursor: pointer;
}

#search {
	
}

#search>select {
	vertical-align:middle;
	width: 100px;
	height: 33px;
	margin: 7px;
	border-radius: 5px;
	border: 1px solid #969696;
	font-size: 120%;
	text-align: center;
}

#search>input {
	width: 230px;
	height: 30px;
	margin: 7px;
	border-radius: 5px;
	border: 1px solid #969696;
	font-size: 120%;
	text-align: center;
	vertical-align:middle;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="template/header.jspf"%>
	<%@ include file="template/menu.jspf"%>
	<div id="contents">
		<!--*****************고객센터 메뉴******************-->
		<div class="grid2">
			<div id="lmsmenu">
				<p>고객센터</p>
				<ul>
					<li class="bigletter"><a href="customercenter.bit">공지사항</a></li>
					<li class="bigletter"><a href="#">FAQ</a></li>
					<li></li>
				</ul>
			</div>
		</div>
		<!--*****************고객센터 메뉴******************-->
		<div id="content" class="grid6">
			&nbsp;
			<!--*************content start****************-->
			<div>
				<span class="title_bar">&nbsp;</span>
				<div class="title_letter">&nbsp;&nbsp;공지사항</div>
			</div>
			<div class="notice-div">

				<table id="notice-table">
					<tr>
						<th>글번호</th>
						<th width="300px">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:forEach items="notice" var="bean">
						<!-- 공지사항 내용 불러오기 -->
						<tr>
<%-- 							<td>${bean.ntnum }</td>
							<td>${bean.title }</td>
							<td>${bean.writer }</td>
							<td>${bean.wtime }</td>
							<td>${bean.read_cnt }</td> --%>
						</tr>
					</c:forEach>

				</table>
				<div id="search-div">
					<form id="search" action="#">
						<select id="searchkey">
							<option value="title">제목</option>
							<option value="writer">작성자</option>
						</select> <input type="text" id="searchword" name="searchword" />
						<button type="submit" id="searchbtn">찾기</button>
					</form>
				</div>
			</div>
			<!--*************content end******************-->
		</div>
		<%@ include file="template/footer.jspf"%>
</body>
</html>