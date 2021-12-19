<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<title>로그인</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner">
	<section>
			<h2 class="major"style="color : #fff">로그인</h2>
			<form method="post" action="/LoginToMain.do">
				<div class="fields">
					<div class="field">
						<label for="id">ID</label>
						<input type="text" name="userid" id="userid" placeholder="ID" required/>
					</div>
					<div class="field">
						<label for="password">Password</label>
						<input type="password" name="userpw" id="userpw" placeholder="password" required/>
					</div>
				</div>
				<input class="button primary fit" type="submit" value="로그인" />
			</form>
			
			<a href="sign.jsp"><input class="button primary fit" type="button" value="회원가입" /></a>
			
	</section>
	</div>
	</div>
</body>
</html>