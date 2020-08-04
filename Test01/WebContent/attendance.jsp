<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {

		/* $('form').each(function() {

			$(this).submit(function() {
					
				var num = $('input[type="hidden"]').val();
				console.log(num);
				$(':radio').each(function() {

					if ($(this).prop('checked')) {

						console.log($(this).val());
						var param = 'num='+num+'&ra=' + $(this).val();
		
						$.post('attendance.bit', param, function() {


						});
					}
				});
							location.href = "result.jsp";
				console.log('adsf');
				return false;
			});

		}); */

		$('#submit').on('click', function() {

			$('.formBtn').each(function() {

				$(this).delay(50).click();
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
			<form id="form" method="post" action="attendance.bit">

				<input type="hidden" name="num" value="11" />
				<div>
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

			<form id="form" method="post" action="attendance.bit">
				<input type="hidden" name="num" value="22" />
				<div>
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

			<form id="form" method="post" action="attendance.bit">
				<input type="hidden" name="num" value="33" />
				<div>
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
			<form id="form" method="post" action="attendance.bit">

				<input type="hidden" name="num" value="44" />
				<div>
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



			<button id="submit">전송</button>
		</fieldset>



	</div>

</body>
</html>