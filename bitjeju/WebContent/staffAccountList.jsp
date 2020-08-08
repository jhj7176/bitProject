<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf"%>
<title>Insert title here</title>

<style type="text/css">
.lmscontent { /* 제목과 테이블을 전부 감싸는 div */
	width: 600px;
	display: block;
	margin: auto;
}
.lmscontent:last-child { /* 이전 다음버튼 감싸는 div 버튼중앙 */
	width: 600px;
	display: block;
	margin: auto;
	text-align:center;
}

#accounttable {
	margin: auto;
	width: 600px;
	border-collapse: collapse;
	border-bottom: 1px solid #e4e4e4;
	border-top: 1px solid #e4e4e4;
}

#accounttable tr {
	text-align: center;
}

#accounttable tr:first-child~tr:hover{/* 테이블 첫번째 tr빼고 hover적용  */
	color: #1E3269;
	background-color:aliceblue;
}

#accounttable th {
	color: #1E3269;
	padding: 30px;
	border-bottom: 1px solid #e4e4e4;
}

#accounttable td {
	padding: 25px;
}

#accounttable a {
	display: block; text-decoration : none;
	color: black;
	text-decoration: none;
}

#accounttable a:hover {
	font-weight: 500;
	color: #1E3269;
}

#accountadd { /* 테이블아래 등록버튼 */
	float: right;
	background-color: #000069;
	border: 1px solid #000069;
	color: white;
	margin: 7px;
	width: 50px;
	height: 20px;
}
#studentprev,#studentnext{/*이전 다음 버튼  */
	background-color: #000069;
	border: 1px solid #000069;
	color: white;
	margin: 7px;
	width: 50px;
	height: 20px;
}
</style>
</head>
<body>
	<%@ include file="template/lmsheader.jspf"%>
	<%@ include file="template/menu.jspf"%>
	<div id="contents">
		<!--*****************lms메뉴******************-->
		<div class="grid2">
			<div id="lmsmenu">
				<p>행정</p>
				<ul>
					<li class="bigletter">계정관리</li>
					<li><a href="lmsstaffaccountlist.bit">회원정보</a></li>
					<li class="bigletter">강의관리</li>
					<li><a href="lmsstafflectureadd.bit">강좌개설</a></li>
					<li><a href="lmsstafflecturelist.bit">강좌정보</a></li>
					<li class="bigletter">수강생관리</li>
					<li><a href="lmsstaffstudentlist.bit">수강생정보</a></li>
					<li></li>
				</ul>
			</div>
		</div>
		<!--*****************lms메뉴******************-->
		<div id="content" class="grid6">
			&nbsp;
			<!--*************content start****************-->
			<div class="lmscontent">
				<h2>계정관리</h2>
				<h4>회원정보</h4>
			<div class="lmscontent">
				<button id="accountadd">등록</button>
			</div>

				<table id="accounttable">
					<tr>
						<th>회원번호</th>
						<th>이름</th>
						<th>구분</th>
					</tr>
					<c:forEach items="${list }" begin="0" end="5" var="bean">
						<tr>

							<td>${bean.num }</td>
							<td><a href="lmsstaffaccountdetail.bit?num=${bean.num}">${bean.name }</a></td>
							<td>${bean.dept }</td>

						</tr>
					</c:forEach>

				</table>
			</div>

			<div class="lmscontent">
				<button id="studentprev">이전</button>
				<button id="studentnext">다음</button>
			</div>
			<!--*************content end******************-->
			<%@ include file="template/footer.jspf"%>
</body>
</html>
<!-- 
-1번라인의 charset, pageEncoding 5번라인의 charset모두 utf-8로 맞춰주세요.
-2번의 doctype도 다지우고 위처럼 html만 남겨주세요.
-content내부에 content와 sidebar로 나눔 ->content에 작업하면됩니다.
-sidebar에서 사용하고 있는 id: #signin #emailid #pw #login #createccount #gotolms #campus #campusinfo #classinfo #open
-footer에서 사용하고있는 id: #footercon
위의 아이디들은 작업시 사용하지 마세요 이름바꾸고 싶으면 저와 의논바람
 -->