<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {
		$('#submit').on('click', function() {
			$('.formBtn').each(function() {
				$(this).click();
			});//each
		});//onclick
	});//ready
</script>


<style type="text/css">
.formBtn {
	display: none;
}
</style>
</head>
<body>

	<div id="target">
		<fieldset>
			<legend>출석</legend>
		<c:forEach var="i" begin="0" end="9">	
			<form  method="post" action="attendance.bit">
				
				<input type="hidden" name="num" value="${i}${i}" />
				
				<div>
				<span>${i}번</span>
					<label>출석</label> 
					<input type="radio" class="ra" value="att" name="ra" /> 
					<label>지각</label> 
					<input type="radio" class="ra" value="late" name="ra" /> 
					<label>결석</label> 
					<input type="radio" class="ra" value="absent" name="ra" />
				</div>
				
				<div>
					<button class="formBtn">저장</button>
				</div>
			</form>
		</c:forEach>
			<button id="submit">전송</button>
		</fieldset>



	</div>

</body>
</html>