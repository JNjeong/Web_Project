
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	      <div class="col-md-3 col-sm-12"><a class="logo" href="/main.do"><img src="images/logo.png" alt=""></a> </div>
	      <div class="col-md-9 hidden-sm hidden-xs">
	        <div class="top-link">
	          <div class="row">
	            <%
					if(session.getAttribute("currUser") == null){
				%>
						
					<div class="col-md-12">
		              <a href="login.do" style="font-size: 32px; margin-top: 15px;">Login</a>
		            </div>
		            
	
				<%
					}else{
				%>
					<div class="col-md-6">
		              <a href="/mypage.do" style="font-size: 32px; margin-top: 15px;">myPage</a>
		            </div>
					<div class="col-md-3">
		              <div><a href="#" onclick="checkLogout()" style="font-size: 32px; margin-top: 15px;">Logout</a></div>
		            </div>
		            <div style="color:skyblue; font-size: 12px; margin-top: 20px;" class="col-md-3" >[${currUser.userid}님<span style="color:black;">환영합니다!</span>]</div>
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
	         
	         <div class="col-md-10 col-sm-12" style="height : 100px;">
	           <div id="navigation" class="navigation">
	             <ul style="margin-top:30px;">
	               <li class="active" style="margin-left : 2%;"><a href="/main.do" title="Home" class="animsition-link" style="">Home</a></li>
	               <li><a href="/boardList.do" title="Contact Us" class="animsition-link">자유게시판</a></li>
	               <li><a href="#" title="Testimonials" class="animsition-link">???</a></li>
	               </ul>
	           </div>
	         </div>
	       </div>
	     </div>
	   </div>
   </div>


</header>