<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header">
			<h1><a href="/main.do">Coin</a></h1>
			<nav>
			<%
				if(session.getAttribute("currUser") != null){
			%>
					<a href="#" style="color:skyblue;">[${currUser.userid}님 환영합니다]</a>
			<%
				}
			%>
				<a href="/boardList.do">Total board</a>
			<%
				if(session.getAttribute("currUser") == null){
			%>
					<a href="login.jsp">Log In</a>
			<%
				}else{
			%>
				<a href="/mypage.do">MY Page</a>
				<a href="/logout.do">Logout</a>
			<%
				}
			%>
			</nav>
</header>