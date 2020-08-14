<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf"%>

<style type="text/css">
#header .grid3{
	margin-top:40px;
	position:relative;
	
}
#lecturecontent{
	display:block;
	margin:auto;
	width:750px;
}

.col-xs-4{
	width:250px;
	height:300px;
	float:left;
	display:block;
	overflow:hidden;
}
.thumbnail{
	width:240px;
	height:280px;
}
.thumbnail:hover{
	background-color:aliceblue;
}
#footer{
	margin-top:400px;
}

</style>
<title>BITCAMP JEJU: 교육과정</title>
</head>
<body>
	<%@ include file="template/header.jspf"%>
	<%@ include file="template/menu.jspf"%>
	<div id="contents">
		<!--*****************lms메뉴******************-->
		<div class="grid2">
			<div id="lmsmenu">
				<p>교육과정</p>
				<ul>
					<li class="bigletter">강좌정보</li>
				<!-- 	<li><a href="lmsteacherattendance.bit">모집공고</a></li> -->

					<li></li>
				</ul>
			</div>
		</div>
		<!--*****************lms메뉴******************-->
		<div id="content" class="grid6">
			&nbsp;
			<!--*************content start****************-->





			<h4>
				<strong><span class="title_bar"></span><span class="bigletter"
					style="color: #041b78">&nbsp;&nbsp;국비지원&nbsp;과정</span></strong>
			</h4>
	
		<div id="lecturecontent">
		<!-- ***********col-xs-4를 foreach로 db에서 모집공고 받아와서 반복.**************** -->
<%-- 		<c:forEach items="${login }">
		
		<div class="col-xs-4">
			<div class="thumbnail" data-id="21" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">제주센터</div>
				<img src="img/logo.png"><!-- 강좌이미지 모집공고이미지 -->
				<div class="caption">
					<h3>${강좌이름 }</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">${개강일 }</span><br />
					<small>교육기간</small>&#124;<br>${ 개강일}~${종강일 }
				</div>
			</div>
		</div>
		
		</c:forEach>
		 --%>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="21" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">서초본원</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스 기반 UIUX Front 전문 개발자 양성과정 B</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-08-17</span><br />
					<small>교육기간</small>&#124;<br>2020-08-17~2021-01-27
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="54" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">서초본원</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>머신러닝 딥러닝을 이용한 AI 전문가 양성 과정</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-08-24</span><br />
					<small>교육기간</small>&#124;<br>2020-08-24~2020-11-04
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="59" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">종로센터</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스 기반 Framework 전문 개발자 양성과정</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-08-25</span><br />
					<small>교육기간</small>&#124;<br>2020-08-25~2021-02-04
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="13" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">서초본원</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스 기반 자바(JAVA)응용SW개발자 양성과정</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-09-01</span><br />
					<small>교육기간</small>&#124;<br>2020-09-01~2021-02-15
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="28" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">강남센터</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스 기반 Framework 전문 개발자 양성과정</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-09-01</span><br />
					<small>교육기간</small>&#124;<br>2020-09-01~2021-02-15
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="55" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">신촌센터</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스 기반 UIUX Front 전문 개발자 양성과정B</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-09-07</span><br />
					<small>교육기간</small>&#124;<br>2020-09-07~2021-02-19
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="61" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">종로센터</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스기반 융합기술을 활용한sw 웹 개발자 양성과정 A</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-09-16</span><br />
					<small>교육기간</small>&#124;<br>2020-09-16~2021-03-03
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="22" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">서초본원</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>프론트엔드 개발을 위한 UIUX전문가 과정 B</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-10-19</span><br />
					<small>교육기간</small>&#124;<br>2020-10-19~2021-03-30
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="thumbnail" data-id="29" data-page="1"
				onclick="course_go(this, '국비지원과정');"
				onmouseenter="box_enter_animation(this);"
				onmouseleave="box_leave_animation(this);"
				style="border: 1px solid rgb(221, 221, 221);">
				<div class="box-tag box-tag-normal">서초본원</div>
				<img src="img/logo.png">
				<div class="caption">
					<h3>디지털컨버전스 기반 Framework 전문 개발자 양성과정</h3>
				</div>
				<div class="text-left price-bar">
					<small>개강일</small>&#124;<span class="orange">2020-11-02</span><br />
					<small>교육기간</small>&#124;<br>2020-11-02~2021-04-13
				</div>
			</div>
		</div>
		
<!-- ***********col-xs-4를 foreach로 db에서 모집공고 받아와서 반복.**************** -->

</div><!-- lecture content -->
			<!--*************content end******************-->
			<%@ include file="template/footer.jspf"%>
</body>
</html>
<!--
-#lmsmenu사용중
-.bigletter는 글씨크기조절용입니다 .logo는 lmslogo사이즈 조절용이예요.
-1번라인의 charset, pageEncoding 7번라인의 charset모두 utf-8로 맞춰주세요.
-3번의 doctype도 다지우고 위처럼 html만 남겨주세요.
-content내부에 content와 sidebar로 나눔 ->content에 작업하면됩니다.
-sidebar에서 사용하고 있는 id: #signin #emailid #pw #login #createccount #campus #campusinfo #classinfo #open
-footer에서 사용하고있는 id: #footercon .gotolms
위의 아이디들은 작업시 사용하지 마세요 이름바꾸고 싶으면 저와 의논바람
 -->