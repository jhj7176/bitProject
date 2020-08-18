<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/head.jspf" %>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
	.bar{
		background-color: #041d79;
		width: 4px;
		height: 18px;
		display: inline-block;
		vertical-align: middle;
	}
	#text{
		color: #041d79;
		font-size: 18px;
		font-weight: 900;
		margin-left: 20px;
		display: inline-block;
		vertical-align: middle;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="template/header.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="contents">
      <!--*****************취업지원 메뉴******************-->
   	<div class="grid2">
        <div id="menuer">
            <p>취업 지원</p>
            <ul>
             		<li>취업 현황</li>
             		<li>취업 공고</li>
            </ul>
        </div>
       </div>
        <!--*****************취업지원 메뉴******************-->
       <div id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
        <div>
      		<span class="bar">&nbsp;</span>
      		<div id="text" >취업 현황</div>
      	</div>	
       <!--*************content end******************-->
       </div>
<%@ include file="template/footer.jspf" %>
</body>
</html>