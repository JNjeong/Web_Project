<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 로그인함수 START -->
	<script type="text/javascript">
	   function newMember(){
	      window.open('new.jsp', '새창으로 회원가입', 'width=500, height=300, menubar=no, status=no, toolbar=no');
	   }
	</script>
	<!-- 로그인함수 END -->
	
	
	
	<!-- 로그인 버튼 START -->
	<ul>
	   <li><a href="signin.jsp">회원가입</a></li>
	   <li><mytag:login /></li>
	</ul>
	<!-- 로그인 버튼 END -->
</body>
</html>