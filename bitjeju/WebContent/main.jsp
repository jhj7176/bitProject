<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<%@ include file="template/head.jspf" %>
<title>BITCAMP JEJU</title>

<script type="text/javascript">
var cnt = 1;
function carousel(){
	
	$('#carouselImg').fadeOut(1000,function(){
		if(cnt==5)cnt=1;	
		$('#carouselImg').fadeIn(1000).attr('src','img/'+cnt+'.jpg');
	});
	cnt++;	
	setTimeout(carousel, 3000);
}

$(function(){
	carousel();
	
	
	
});


</script>
</head>
<body>
<%@ include file="template/header.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="carousel" class="gird12">
       <img id ="carouselImg" src="img/forc.jpg">
   </div><!--carousel-->
   <div id="contents">
   
   
       <div class="grid2">&nbsp;</div>
       <div  id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
      


   <img src="img/capture.PNG">


       <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
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