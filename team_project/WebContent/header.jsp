<header id="header">
<meta charset="UTF-8">
			<h1><a href="/main.do">Coin</a></h1>
			<nav>
				<a href="/boardList.do">Total board</a>
			<%
				if(session.getAttribute("currUser") == null){
			%>
					
					<a href="/LoginToMain.do">Log In</a>

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