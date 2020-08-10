<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/960.css" />
<script type="text/javascript" src="jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
	var selectDate;
	
$(function(){
	  document.getElementById('nalja').value = new Date().toISOString().substring(0, 10);
	  selectDate = $('#nalja').val();
	  
	  $('#nalja').on('change',function(){
		 selectDate = $('#nalja').val();
	  	$('.nalja').val(selectDate);
		})//날짜 input 클릭
		
		$('.nalja').val(selectDate);
	  console.log(selectDate);

		
		$('.nalja').css('display','none')
		
	});
</script>


<style type="text/css">
#header {
	
}
#menu {
	margin-bottom: 10px;
}
#menu>ul {
	overflow: hidden;
	margin: auto;
	padding: 0px;
	list-style: none;
	text-align: center;
	width: 406px;
}
#menu>ul>li {
	
	float: left;
	padding: 0px;
	margin: 0px;
	border-left: 1px dotted gray;
/* 	border-bottom:1px solid gray; */
	width: 100px;
	height: 50px;
	line-height: 50px;
	width: 100px;
}
#menu>ul>li+li+li+li {
	border-right: 1px dotted gray;
}
#menu>ul>li:hover {
	background-color: aliceblue;
}
#menu>ul>li>a {
	text-decoration: none;
	display: block;
	color: black;
}
#content {
	
}
#content>div>img {
	margin: auto;
}
.grid_12 {
	float: left;
	margin: 0px;
}
.grid_4 {
	float: right;
}
#centerContent {
	border: 1px solid; 
	width : 690px;
	height: 400px;
	width: 690px;
}
#atttable{
	diplay:block;
}
#login {
	height: 220px;
	width: 212px;
	margin-bottom: 10px;
}
#login>fieldset {
	margin: 0px;
	padding: 0px;
	width: 200px;
	padding: 0px;
	width: 200px;
	height: 220px;
}
#login>fieldset>form {
	width: 200px;
}
#login>fieldset>form button {
	display:block;
	margin:auto;
	background-color: white;
	cursor: pointer;
	border: 0px;
}
#login>fieldset>form>ul {
	padding: 0px;
	width: 200px;
	overflow: hidden;
	width: 200px;
}
#login>fieldset>form>ul>li {
	display: inline-block;
	width: 180px;
	list-style: none;
	padding: 0px;
	/* margin-left: -30px; */
}
#login>fieldset>form>ul>li>span {
	float: left;
	margin-left: 20px;
}
#login>fieldset>form>ul>li>input {
	float: right;
}
#ad {
	padding: 0px;
}
#ad>ul {
	list-style: none;
	overflow: hidden:
}
#btn_lms{
	width:202px;
	height:30px;
	border:1px solid gray;
	background-color:white;
	margin-bottom:5px;
	font-size:110%;
	color:#575757;
}
#ad>ul>li {
	/* margin-left:-30px; */
	padding: 0px;
}
#footer {
	margin-top: 50px;
}
#footer>div:first-child {
	width: 580px;
	margin: auto;
	display: block;
}
#footer>div>img {
	float: left;
}
#footer>div>div {
	float: left;
}
#table,.form{
	overflow:hidden;
}
</style>
</head>


<body>

	<div class="container_16">
		<div id="header" class="grid_16">
			<a href="index.bit"><img alt="" src="img/bitcamp_logo.png"></a>
		</div>
		<div class="clear"></div>
		<div id="menu" class="grid_16">
			<ul>
				<li><a href="">비트캠프</a></li>
				<li><a href="">교육과정</a></li>
				<li><a href="">취업센터</a></li>
				<li><a href="">고객센터</a></li>
			</ul>
		</div>
		<div class="clear"></div>

		<div id="content" class="grid_16">
			<!--content start  -->

			<div class="grid_16">
				<img alt="" width="95%" src="img/big2.jpg"> 
				<img alt="" width="95%" src="img/big1.jpg">
			</div>
			
			<div class="clear"></div>

			<div class="grid_12">

		<div id="centerContent"> 
				<h1>LMS출석부</h1>
		<label for="nalja">날짜:${empty list}</label>
		<input type="date" id="nalja" name="nalja">
	
	
					<!-- 	<div id="table" > -->
			<form class="form" method="post" action="result.bit">
			
					<c:forEach items="${list}" varStatus="status" var="bean"><!--수강생 수만큼 반복.  -->
							<table id="atttable">
								<tr>
									<th>학번</th>
									<th>상태</th>
								</tr>
								<tr>
									<td align ="center" >
									${list.get(status.index).num }
									<input type="hidden" name="num${list.get(status.index).num }" value="${list.get(status.index).num }"><!--파라미터:수강생번호  -->
									<input type="date" class="nalja" name="nalja${list.get(status.index).num }">						<!--파라미터 출석정보에 넣을 날짜 -->
								</td>
								<td>
									<label for="ra">출석</label>
									<input type="radio" class="state" name="state${list.get(status.index).num }" value="attend">	<!-- 출석,지각,결석 중 하나 선택해서 파라미터로보냄 -->
									<label for="ra">지각</label>
									<input type="radio" class="state" name="state${list.get(status.index).num }" value="late">	<!--name에 전부 학번을 넣어서 컨트롤러에서 구분해서 value사용함  -->
									<label for="ra">결석</label>
									<input type="radio" class="state" name="state${list.get(status.index).num }" value="absent">
								</td>
								</tr>
							</table>
				
					</c:forEach>
			<button id="fin">완료</button>
			</form>
						<!-- </div> -->


			</div>

			</div>



			<div class="grid_4">
				<div id="login">
					<fieldset>
						<legend id="login_title">비트캠프로그인</legend>
						<form id="side_login" method="post" action="login.bit">
		<!--FORM SUBMIT하면 로그인 컨트롤러로 가서 DB회원정보와 비교 후 일치하면 세션만들고 사이드바변경.-->
			<c:choose>
				<c:when test="${empty login}"><!-- 세션 attribution인 "login"이 null이면 id,pw 입력폼이 나타남 -->
								<ul>
									<li><span>ID&nbsp;</span><input type="text" name="id_email"
										size="15" id="id" /></li>
	
									<li><span>PW&nbsp;</span><input type="password" name="password"
										size="15" id="pw" /></li>
								</ul>
								
								<button type="submit">
									<img alt="" src="img/btn_login.png" />
								</button>
								<button>
									<img alt="" src="img/btn_join.png" />
								</button>
				<!-- <p>체크1</p> -->
				
				</c:when>

				<c:when test="${not empty login}"> <!-- 세션 attribution인 "login"이 null아니면 해당세션 회원의 이름이 나타남 -->
								<ul>
									<li><span>${login.name}님 환영합니다.&nbsp;</span></li>
	
									<li><span>&nbsp;</span></li>
								</ul>
								
								<button type="submit">
									<img alt="" src="img/btn_logout.png" />
								</button>
								<button>
									<img alt="" src="img/btn_join.png" />
								</button>
							<!-- 	<p>체크2</p> -->
				</c:when>
			</c:choose>
							<!-- 		<button><img alt="" src="img/btn_join.png"/></button> -->
						</form>
					</fieldset>

				</div>


				<div id="ad">
					<form action="lms.bit" method="post">
					<input type="hidden" name="deptno" value="${login.deptno}"/>
					<button id="btn_lms" >LMS</button>					
					</form>
					<img alt="" src="img/btn1.png"> 
					<img alt="" src="img/btn3.png">
				</div>
			</div>
			
			
		<div class="clear"></div>
			<div class="grid_16">&nbsp;</div>
			<div class="grid_16">
				<img alt="" width="95%" src="img/big3.jpg">
			</div>

			<!--content end -->
		</div>
		<div class="clear"></div>
		

		<div id="footer" class="grid_16">
			<!--footer Start  -->
			<div>
				<img alt="" src="img/footer-logo.png">
				<div>
					<address>비트캠프 서울시 서초구 강남대로 459</address>
					(주)비트컴퓨터 서초본원<br /> Copyright &copy; 비트캠프 All rights reserved.
				</div>
			</div>

			<!--footer end  -->
		</div>






	</div>
</body>


</html>