<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<title>마이페이지</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner">
	<section>
			<h2 class="major">마이페이지</h2>
			<form method="post" action="/userUpdate.do">
				<div class="fields">
					<div class="field">
						<label for="id">ID</label>
						<input type="text" name="userid" id="userid" required/>
						<font id="checkId"></font>
					</div>
					<div class="field">
						<label for="password">Password</label>
						<input type="password" name="userpw" id="userpw"  required/>
					</div>
										<div class="field">
						<label for="name">Name</label>
						<input type="text" name="username" id="username" required/>
					</div>
					<div class="field">
						<label for="email">Email</label>
						<input type="email" name="useremail" id="useremail" required/>
					</div>
					<div class="field">
						<label for="phoneNumber">Phone</label>
						<input type="tel" name="userphone" id="userphone" />
					</div>
				</div>
				<input class="button primary fit" type="submit" value="수정하기" />
			</form>
			
			<a href="/SignToMain.do"><input class="button primary fit" type="button" value="회원탈퇴" /></a>
	</section>
	</div>
	</div>
</body>
</html>