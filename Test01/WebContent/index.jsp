<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/960.css" />
<script type="text/javascript" src="jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {

	});//ready
</script>

<style type="text/css" rel="stylesheet">
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
</style>



</head>


<body>

	<div class="container_16">
		<div id="header" class="grid_16">
			<img alt="" src="img/bitcamp_logo.png">
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
				<div id="centerContent">컨텐츠</div>
			</div>



			<div class="grid_4">
				<div id="login">
					<fieldset>
						<legend id="login_title">비트캠프로그인</legend>
						<form id="side_login" method="post" action="#servlet#">
		<!--FORM SUBMIT하면 로그인 컨트롤러로 가서 DB회원정보와 비교 후 일치하면 세션만들고 사이드바변경.-->
							<ul>
								<li><span>ID&nbsp;</span><input type="text" name="id"
									size="15" id="id" /></li>

								<li><span>PW&nbsp;</span><input type="password" name="pw"
									size="15" id="pw" /></li>
							</ul>
							<button>
								<img alt="" src="img/btn_login.png" />
							</button>
							<button>
								<img alt="" src="img/btn_join.png" />
							</button>
							<!-- 		<button><img alt="" src="img/btn_join.png"/></button> -->
						</form>
					</fieldset>

				</div>


				<div id="ad">
					<button id="btn_lms" >LMS</button>
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