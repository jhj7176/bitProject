<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf"%>


<title>BITCAMP JEJU: LMS행정-강좌수정</title>

<script type="text/javascript">

var teacher = "${lecture.name}";
var lecture_room = "${lecture.lecture_room}";
$(function(){
	console.log(teacher, lecture_room);
	$('#lectureroomselect option').each(function(){ //옵션들중에 일치하는 강의실 찾아서 선택.
		console.log($(this).val());
		if($(this).val()==lecture_room){
			$(this).prop('selected',true);
		}//if
	});//each
	$('#teacherselect option').each(function(){//일치하는 강사를 찾아서 선택.
		console.log($(this).val());
		if($(this).val()==teacher){
			$(this).prop('selected',true);
		}//if
	});//each
});//ready


</script>
<style type="text/css">
.lmscontent {
	width: 600px;
	display: block;
	margin: auto;
	border-bottom: 1px solid #e4e4e4;
}

.lmscontent:last-child{
	margin-bottom:400px;
}
#lecturetable {
	border-collapse: collapse;
}

#lecturetable tr {
	
}

#lecturetable th {
	color: #1E3269;
	padding: 30px;
	border-right: 1px solid #e4e4e4;
	text-align: right;
}

#lecturetable td {
	padding: 25px;
	text-align: left;
}

#lecture_name,#start_day,#end_day,#teacherselect,#lectureroomselect{
    width: 230px;
    height: 43px;
    margin: 7px;
    border-radius: 5px;
    border: 1px solid #969696;
    font-size:120%;
    text-align:center;
}

#lectureadd, #lectureback {
	float: right;
	background-color: #000069;
	border: 1px solid #000069;
	color: white;
	margin: 7px;
	width: 50px;
	height: 20px;
}
#lectureadd:hover, #lectureback:hover {
		background-color:white;
		color:#000069;
		cursor: pointer;
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
			<form action="lmsstafflectureedit.bit" method="post">
			<div class="lmscontent"><!--**********lmscontent start**********-->
				<h2>강의관리</h2>
				<h4>강좌수정</h4>
					<table id="lecturetable">
						<tr>
							<th>강좌명</th>
							<td><input type="text" name="lecture_name" id="lecture_name"
								value="${lecture.lecture_name }"/></td>
						</tr>
						<tr>
							<th>강사명</th>
							<td>
							<select id="teacherselect" name = "name">
									<c:forEach items ="${teacherList }" var="name">
									<option>${name }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>강의실</th>
							<td><select id="lectureroomselect" name="lecture_room">
									<option>201</option>
									<option>202</option>
									<option>203</option>
							</select></td>
						</tr>
						<tr>
							<th>개강일</th>
							<td><input type="date" name="start_day" id="start_day" value="${lecture.start_day }"/></td>
						</tr>
						<tr>
							<th>종강일</th>
							<td><input type="date" name="end_day" id="end_day" value="${lecture.end_day }"/></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="hidden" id="lecture_num" name="lecture_num" value="${lecture.lecture_num }"/></td>
						</tr>
					</table>
			</div><!--**********lmscontent end**********-->
			<div class="lmscontent">
				<button id="lectureback" type="button" onclick="window.history.go(-1)">뒤로</button>
				<button id="lectureadd" type="submit">등록</button>

			</div>
			</form>
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