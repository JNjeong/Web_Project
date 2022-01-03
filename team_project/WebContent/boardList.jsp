<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/minor.css">
<head>
    <jsp:include page="head.jsp"/>
	<title>게시글</title>
</head>

<body>
	 <jsp:include page="header.jsp"></jsp:include>
		<div class="wrapper">
		<div class="inner">
		<section>
			<h3 class="major" style="color:#fff; font-family: 'EliceDigitalBaeum_Bold';">자유 게시판</h3>
			<div class="table-wrapper">
				<table>
						<thead>
							<tr>
								<!-- BOARD COUNT -->
								<td colspan="5" align=right>
									<h5 class="major"
										style="color: #fff; font-family: 'EliceDigitalBaeum_Bold';">
										게시글 수 : <c:out value="${brdcount}"/></h5>
								</td>
							</tr>
							<tr>
								<th>No.</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
					<tbody>
						<c:forEach var="boardarr" items="${boardarr}" varStatus="status">
								<tr onclick="location.href='/board.do?brdcode=${boardarr.brdcode}'" style="cursor:pointer">
									<td><c:out value = "${status.count}"/></td>
									<td>${boardarr.brdtitle}</td>
									<td>${boardarr.brdwriter}</td>
									<td>${boardarr.brddate }</td>
									<td>${boardarr.brdvisited}</td>
									
								</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="field">
					<form action="/searchList.do" method="post">
						<select class="select" name="type" id="type" style="float:left; width:100px !important; display:inline-block; height: 50px;">
							<option value="작성자">작성자</option>
							<option value="내용" selected>내용</option>
							<option value="제목">제목</option>						
						</select>
						<input class="search" type="text" name="result" id="result" style="float:left; width:300px; display:inline-block; height:50px;">
						<input type="submit" value="검색" style="float:left; display:inline-block; height: 50px; font-family:'EliceDigitalBaeum_Bold';">				
					</form>

							<a href="form.jsp" class="button primary" style="float:right;">글쓰기</a>
	
				
				</div>
			</div>
		</section>
		</div>
			<jsp:include page="footer.jsp"/>
		
		</div>
		
</body>

</html>