
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/minor.css">
<link rel="stylesheet" href="css/header.css">

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

const checkLogout = function() {
	var result = confirm("정말 로그아웃을 하시겠습니까?");
	 if(result){
	     location.href="/logout.do";
	 }else return;
}
 
 </script>

<header style="background-color:#fff;">
			
	<div class="top-header"><!-- top header -->
	  <div class="container">
	    <div class="row">
	      <div class="col-md-3 col-sm-12"><a class="logo" href="/main.do"><img src="images/logo.png" alt="로고사진"></a> </div>
	      <div class="col-md-9 hidden-sm hidden-xs" style="">
	        <div class="top-link">
	          <div>
	            <%
					if(session.getAttribute("currUser") == null){
				%>
						
					<div class="col-md-12" style="margin-top:20px;">
		              <a href="login.jsp" class="loginmouseon" style="font-size:30px; color:black; width:100%; font-family:'EliceDigitalBaeum_Bold'">Login</a>
		            </div>
		            
	
				<%
					}else{
				%>
					
		            
					<div class = "colorgold" style="display:block; float:right; margin-top:34px; width:50%; display:flex; justify-content:space-between;">
		            	<div style="color:black; font-size: 12px; margin-top: 22px; display:inline-block; font-family:'EliceDigitalBaeum_Bold'; line-height:30px;">
		            		<img src="/images/account.png" alt="프로필사진" class="accountpic" style="height:38px; widht:38px; margin-bottom:16px;">
		            		<span style="font-size:30px; margin-bottom:16px;">${currUser.userid}</span>
		            	</div>
		              	<a href="/mypage.do" class="loginmouseon" style="font-size: 30px; margin-top:15px; color:black; font-family:'EliceDigitalBaeum_Bold';">MYPAGE</a>
		              	<a href="#" class="loginmouseon" onclick="checkLogout()" style="font-size: 30px; margin-top: 15px; color:black; font-family:'EliceDigitalBaeum_Bold';">LogOut</a>
		            </div>
				<%
					}
				%>
				
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class=""><!-- navigation-transparent -->
	   <div class="header" style="background-color: #2e3141;"><!-- navigation -->
	     <div class="container">
	       <div class="row">
	         
	         <div class="col-md-10 col-sm-12" style="height:80px;">
	           <div id="navigation" class="navigation">
	             <ul style="margin-top:20px;">
	               	<li class="active" style="margin-left:2%; font-size: 20px !important;"><a href="/main.do" class="animsition-link">
	               		<span class="mouseon" style="font-size:20px !important; margin-right:36px;">Home</span></a></li>
	               	<li><a href="boardList.do" class="animsition-link">
	               		<span class="mouseon" style="font-size:20px !important; margin-left:30px;">자유게시판</span></a></li>
	             </ul>
	           </div>
	         </div>
	       </div>
	     </div>
	   </div>
   </div>


</header>