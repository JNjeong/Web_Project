<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta charset="UTF-8">
<title>게시글</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
		<div class="wrapper">
		<div class="inner">
		<section>
			<h3 class="major" style="color : #fff">자유 게시판</h3>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>No</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="boardarr" items="${boardarr}" varStatus="status">
								<tr onclick="location.href='/board.do?brdcode=${boardarr.brdcode}'" style="cursor:pointer">
									<td><c:out value = "${status.count}"/></td>
									<td>${boardarr.brdtitle}</td>
									<td>${boardarr.brdwriter}</td>
									<td>${boardarr.brddate}</td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<%
					if(session.getAttribute("currUser") != null){
				%>
				<a href="form.jsp" class="button primary" style="float:right;">글쓰기</a>
				<%
					}
				%>
			</div>
		</section>
		</div>
		</div>
</body>
</html>