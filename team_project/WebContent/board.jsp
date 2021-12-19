<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<script>

const checkDeleteBoard = function() {
	var result = confirm("정말 글을 삭제 하시겠습니까?");
	 if(result){
	     location.href="/brdDelete.do?brdcode="+${brdvo.brdcode};
	 }else return;
}
 
 </script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		
		<div class="wrapper">
			<div class="inner">
			
				<div class="table-wrapper">
					<h1 style="color:#fff"><input type="text" value="${brdvo.brdtitle}" readonly/></h1>
						<input type="text" value="작성자 : ${brdvo.brdwriter}" readonly/>
						<input type="text" value="추천 :${brdvo.brdlike}" readonly/>
						<input type="text" value="비추천 : ${brdvo.brddislike}" readonly/>
						<input type="text" value="방문수 : ${brdvo.brdvisited}" readonly/>
						<input type="text" value="작성날짜 : ${brdvo.brddate}" readonly/>
						<textarea name="demo-message" id="demo-message" rows="6" readonly="readonly">${brdvo.brdcontent}</textarea>
				
				
				<%
					if(request.getAttribute("user_eq").equals("T")){
				%>
				<div style="float:right; margin-top: 10px;margin-left:10px;">
					<a href="#" class="button primary">수정</a>
					<a href="#" onclick="checkDeleteBoard()" class="button primary">삭제</a>
				</div>
				<% 		
					}
				%>
				
				</div>
			</div>
		</div>
</body>
</html>