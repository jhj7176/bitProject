<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bitgrid.css">
<%@ include file="template/lmshead.jspf" %>
<meta charset="UTF-8">
<title>BITCAMP JEJU: LMS강사-출석체크</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

var selectDate;
$(function(){
  document.getElementById('nalja').value = new Date().toISOString().substring(0, 10);
  selectDate = $('#nalja').val();
  $('.nalja').val(selectDate);
  $('.nalja').css('display','none')
});
</script>
<style type="text/css">
tr{
   border:1px solid;
}
td{
   border:1px solid;
}
</style>
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
                    <a href="#">수강생정보</a>    
                </li>
                <li>
                    <a href="#">성적입력</a>    
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
	   <h1>출석체크</h1>
	      <label for="nalja">날짜:</label>
	      <input type="date" id="nalja" name="nalja">
	   <form method="post" action="lmsteacherattlist.bit">
	   <c:forEach items="${list}" varStatus="status" var="bean">
	   <div id="table">
	      <table>
	         <tr>
	            <th>학번</th>
	            <th>이름</th>
	            <th>상태</th>
	         </tr>
	         <tr>
	            <td align ="center" >
		            ${bean.num }
		            <input type="hidden" name="num${bean.num }" value="${bean.num }">
		            <input type="date" class="nalja" name="nalja${bean.num }">
	            </td>
	            <td>
	            	${bean.name }
	            </td>
	            <td>
		            <label for="ra">출석</label>
		            <input type="radio" class="state" name="state${bean.num }" value="출석">
		            <label for="ra">지각</label>
		            <input type="radio" class="state" name="state${bean.num }" value="지각">
		            <label for="ra">조퇴</label>
		            <input type="radio" class="state" name="state${bean.num }" value="조퇴">
		            <label for="ra">결석</label>
		            <input type="radio" class="state" name="state${bean.num }" value="결석">
	             </td>
	         </tr>
	      </table>
	   </div>
	   </c:forEach>
	   <button id="fin">완료</button>
	   </form>
       <!--*************content end******************-->
<%@ include file="template/footer.jspf" %>
</body>
</html>