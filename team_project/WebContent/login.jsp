<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/minor.css">
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
			<h2 class="major"style="color:white; font-family:'EliceDigitalBaeum_Bold'; font-size:30px;">Log in to Your Account</h2>
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
				<input class="button primary fit" type="submit" value="LogIn" />
			</form>
			
			<a href="signin.jsp"><input class="button primary fit" type="button" value="Sign in for an Account" /></a>
			
	</section>
	</div>
	</div>
</body>
</html>