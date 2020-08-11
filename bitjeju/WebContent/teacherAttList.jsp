<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="template/lmshead.jspf" %>
<title>BITCAMP JEJU: LMS강사-출석조회</title>
<style type="text/css">
.lmscontent {
	width: 600px;
	display: block;
	margin: auto;
}
.lmscontent:last-child {
	margin-bottom:300px;
}
#searchbyname{
	width: 100px;
}
.btn{/*버튼 조절*/
    background-color: #000069;
    border:1px solid #000069;
    color:white;
    margin: 7px;
    width: 50px;
    line-height: 20px;
}
#attendtable{
	text-align:center;
	margin: 20px auto;
	border-collapse:collapse;
}
#attendtable th{
	width: 200px;
	color:#1E3269;
	padding:10px;
	border-left:1px solid #e4e4e4;
	text-align:center;
}
#attendtable td{
	border-left:1px solid #e4e4e4;
	padding:25px;
	text-align:center;
}
#attendtable tr:first-child~tr:hover{/* 테이블 첫번째 tr빼고 hover적용  */
	color: #1E3269;
	background-color:aliceblue;
}
.apopup{
	text-decoration: none;
    color: black;
}
#spanpopup{/* 팝업창 나오게하는 폼데이터.  */
	display:none;
}
</style>
<script type="text/javascript">
	$(function(){
		$('.apopup').each(function(){
			var pnalja = $(this).text();//누른 날짜.
			var pnum = $(this).prev().text();
			$(this).on('click',function(){
				 $.ajax('lmsteacherattupdate.bit',{
					'method':'get',
					'data':'num='+pnum+'&nalja='+pnalja,
					'success':function(){
						var date= pnalja;
						var title="new window";
						var option = "width=600,height=500,top=200,left=400, toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no";
						window.open("lmsteacherattupdate.bit?num="+pnum+"&nalja="+pnalja,title,option);			  
						console.log('성공');
					} 		
				})//ajax
					return false;
			});//click
		});//each	
});
</script>
</head>
<body>
<%@ include file="template/lmsheader.jspf" %>
<%@ include file="template/menu.jspf" %>
   <div id="contents">
   <!--*****************lms메뉴******************-->
       <div class="grid2">
        <div id="lmsmenu">
            <p>강사</p>
            <ul>
                <li class="bigletter">출결관리</li>
                <li>
                    <a href="lmsteacherattendance.bit">출석체크</a>    
                </li>
                <li>
                    <a href="lmsteacherattlist.bit">출석조회</a>    
                </li>
                <li class="bigletter">수강생관리</li>
                <li>
                    <a href="lmsteacherstulist.bit">수강생정보</a>    
                </li>
                <li>
                    <a href="lmsteacherstugrade.bit">성적관리</a>    
                </li>
                <li>
                    <a href="#" class="bigletter">자료실</a>    
                </li>
                <li></li>
            </ul>
        </div>
       </div>
        <!--*****************lms메뉴******************-->
       <div  id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
    <div class="lmscontent">
    <h2>출결관리</h2>
	<h4>출석조회</h4>
	<form action="lmsteacherattsearchbydate.bit" method="post">
		<input type="date" class="date" name="nalja1"><span>~</span>
		<input type="date" class="date" name="nalja2">
		<button class="btn">조회</button>
	</form>
	<form action="lmsteacherattsearchbyname.bit" method="post">
		<input type="text" id="searchbyname" name="name" placeholder="이름으로 검색">
		<button class="btn">조회</button>
	</form>
	<div id="attendtable">
		<table>
			<tr>
				<th>날짜</th>
				<th>학번</th>
				<th>이름</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${list}" var="list">
			<tr >
				<td><span id="spanpopup">${list.num }</span><a class ="apopup" href="#">${list.nalja}</a></td>
				<td>${list.num }</td>
				<td>${list.name }</td>
				<td>${list.state }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</div>
	 <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
</body>
</html>