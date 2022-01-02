<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/minor.css">
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<title>마이페이지</title>
</head>
<script>
	const checkBeforeDelete = function(){
		delresult = confirm("정말로 탈퇴하시겠습니까?");
		if(delresult) location.href="/userDelete.do";
		else return;
	}
</script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner">
	<section>
			<h2 class="major" style="color:#fff; color:white; font-size: 30px; font-family:'EliceDigitalBaeum_Bold' !important;">MY PAGE</h2>
			<form method="post" action="/userUpdate.do">
				<div class="fields">
					<div class="field">
						<label for="id">ID</label>
						<input type="text" name="userid" id="userid" value="${currUser.userid}" disabled/>
						<font id="checkId"></font>
					</div>
					<div class="field">
						<label for="password">Password</label>
						<input type="password" name="userpw" id="userpw" value="${currUser.userpw }"/>
					</div>
					<div class="field">
						<label for="name">Name</label>
						<input type="text" name="username" id="username" value="${currUser.username }"/>
					</div>
					<div class="field">
						<label for="email">Email</label>
						<input type="email" name="useremail" id="useremail" value="${currUser.useremail }"/>
					</div>
					<div class="field">
						<label for="phoneNumber">Phone</label>
						<input type="tel" name="userphone" id="userphone" value="${currUser.userphone }"/>
					</div>
				</div>
				<input class="button primary fit" type="submit" value="수정하기" />
			</form>
			<input class="button primary fit" type="button" value="회원탈퇴" onclick="checkBeforeDelete()"/>
	</section>
	</div>
	</div>
</body>
</html>