<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/lmshead.jspf" %>
<title>BITCAMP JEJU: LMS수강생-출결조회</title>
<style type="text/css">
.lmscontent {
	width: 600px;
	display: block;
	margin: auto;
}
.lmscontent:last-child {
	margin-bottom:300px;
}
#atttable{
	width:600px;
	border-collapse:collapse;
	font-size:110%;
}
#atttable th{
	color:#1E3269;
	padding:30px;
	border-right:1px solid #e4e4e4;
	text-align:right;
}
#atttable td{
	padding:25px;
	text-align:left;
}
#atttable td>span{
	line-height:35px;
}
.btn{/*버튼 조절*/
	vertical-align: middle;
	font-size: 14px;
	text-decoration: none;
    background-color: #000069;
    border:1px solid #000069;
    color:white;
    margin: 7px;
    width: 60px;
    line-height: 20px;
    float:right;
}
.btn:hover{
    background-color: white;
    border:1px solid #000069;
    color:#000069;	
    cursor: pointer;
}
#classRange,#attRange{
	width:250px;
	background-color:beige;
}
</style>
<script type="text/javascript">
	var attRate ="${bean.attRate()}";	//출석률
	var classRate = "${bean.classProgress()}"; //수업진행률
	 $(function(){
		$('#attRange').prop('value',attRate);
		$('#classRange').prop('value',classRate);		 
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
            <p>수강생</p>
            <ul>
                <li class="bigletter">
                    <a href="lmsstugrade.bit">성적조회</a>    
                </li>
                <li class="bigletter">
                    <a href="lmsstuattlist.bit">출결조회</a>    
                </li>
                <li class="bigletter">
                    <a href="lmsstulecture.bit">수강정보</a>    
                </li>
                <li class="bigletter">
                    <a href="" class="bigletter">자료실</a>    
                </li>
                <li></li>
            </ul>
        </div>
       </div>
        <!--*****************lms메뉴******************-->
       <div  id="content" class="grid6">&nbsp;
       <!--*************content start****************-->
       <div class="lmscontent">
       <h2>출결조회</h2>
       <table id="atttable">
       <c:set value="${bean }" var="bean" />
       		<tr>
				<th>수업 진행률</th>
				<td><progress id="classRange" max="100"></progress> ${bean.classProgress()}%</td>
			</tr>
			<tr>
				<th>출석률</th>
				<td><progress id="attRange" max="100"></progress> ${bean.attRate()}%</td>
			</tr>
			<tr>
				<th>출석</th>
				<td>${bean.cntAtt() }회</td>
			</tr>
			<tr>
				<th>지각</th>												
				<td><span>${bean.cntLate() }회</span><a class="btn" href="lmsstuattdetail.bit?num=${login.num}&state=late">상세보기</a></td>
			</tr>
			<tr>
				<th>조퇴</th>
				<td><span>${bean.cntEarly() }회</span><a class="btn" href="lmsstuattdetail.bit?num=${login.num}&state=leave">상세보기</a></td>
			</tr>
			<tr>
				<th>결석</th>
				<td><span>${bean.cntAbsent() }회</span><a class="btn" href="lmsstuattdetail.bit?num=${login.num}&state=absent">상세보기</a></td>
			</tr>
       </table>
       </div>
       <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
</body>
</html>