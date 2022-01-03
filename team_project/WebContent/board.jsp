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
				<form action="/boardToUpdate.do" method="post">
					<div class="table-wrapper">
						<h1 style="color:#fff"><input type="text" name="brdtitle" value="${brdvo.brdtitle}" readonly/></h1>
							<input type="hidden" value="${brdvo.brdcode}" name="brdcode"/>
							<input type="text" value="작성자 : ${brdvo.brdwriter}" name="brdwriter" readonly/>
							<input type="text" value="추천 :${brdvo.brdlike}" name="brdlike" readonly/>
							<input type="text" value="비추천 : ${brdvo.brddislike}" name="brddislike" readonly/>
							<input type="text" value="조회수: ${brdvo.brdvisited}" name="brdvisited" readonly/>
							<input type="text" value="작성날짜 : ${brdvo.brddate}" name="brddate"  readonly/>
							<textarea name="brdcontent" id="brdcontent" rows="6" readonly="readonly">${brdvo.brdcontent}</textarea>
					
					
					<div style="float:right; margin-top: 10px;margin-left:10px;">
						<a href="/boardList.do" class="button primary">뒤로가기</a>
					</div>
					
					<%
						if(request.getAttribute("user_eq").equals("T")){
					%>
					<div style="float:right; margin-top: 10px;margin-left:10px;">
						<input type="submit" class="button primary" value="수정">
						<a href="#" onclick="checkDeleteBoard()" class="button primary">삭제</a>
						
					</div>
					<% 		
						}
					%>
					
					</div>
				</form>
			</div>
		</div>
</body>
</html>