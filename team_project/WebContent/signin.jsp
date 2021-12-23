<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="head.jsp"></jsp:include>
	<title>회원가입</title>
</head>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	$(function(){
		$("#userid").focusout(function(){
			let userid = $("#userid").val();
			console.log("작성한userid"+userid);
			$.ajax({
				url :"/idCheck.do",
				type: "post",
				data : {userid : userid},
				dataType : 'json',
				success : function(result){
					if(result == 0){
						$("#checkId").html('이미 있는 아이디입니다.');
						$("#checkId").attr('color', 'red');
						$("#userIdChkResult").val(false);
						console.log("이미있는아이디"+$("#userIdChkResult").val());
					}else{
						$("#checkId").html('사용할 수 있는 아이디 입니다.');
						$("#checkId").attr('color', 'green');
						$("#userIdChkResult").val(true);
						console.log("사용가능한아이디"+$("#userIdChkResult").val());
					}
				},
				error :function(){
					alert("서버 요청 실패!")
				}
			})
		});
	});
	
	
	
</script>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner">
	<section>
			<h2 class="major">회원가입</h2>
			<form method="post" action="/UserInsert.do">
				<div class="fields">
					<div class="field">
						<label for="id">* ID</label>
						<input type="text" name="userid" id="userid" required/>
						<font id="checkId"></font>
						<input type="hidden" id="userIdChkResult"/>
						
					</div>
					<div class="field">
						<label for="password">* Password</label>
						<input type="password" name="userpw" id="userpw"  required/>
					</div>
										<div class="field">
						<label for="name">* Name</label>
						<input type="text" name="username" id="username" required/>
					</div>
					<div class="field">
						<label for="email">* Email</label>
						<input type="email" name="useremail" id="useremail" required/>
					</div>
					<div class="field">
						<label for="phoneNumber">Phone</label>
						<input type="tel" name="userphone" id="userphone" />
					</div>
				</div>
				<ul style="text-align: center; list-style: none;">
					<li><input class="button primary fit" type="submit" value="가입하기" /></li>
				</ul>
			</form>
	</section>
	</div>
	</div>
</body>
</html>