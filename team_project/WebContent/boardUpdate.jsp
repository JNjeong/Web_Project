<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/minor.css">
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner" style="clear:both;">
	<section>
			<%--
			<h2 class="major" style="color: #fff; font-family:'EliceDigitalBaeum_Bold';">글 수정</h2>
			--%>			
			<form method="post" action="/brdUpdate.do">
			<input type="hidden" name="brdcode" id="brdcode" value=<%=request.getParameter("brdcode")%>>
			<input type="hidden" name="brdwriter" id="brdwriter" value=<%=request.getParameter("brdwriter")%>>
				<div class="fields">
					<div class="field">
						<input type="text" name="brdtitle" id="brdtitle" placeholder="제목" value="<%=request.getParameter("brdtitle")%>" required/>
					</div>
					<div class="field">
						<textarea name="brdcontent" id="brdcontent" rows="10" placeholder="내용"  required><%=request.getParameter("brdcontent")%></textarea>
					</div>
				</div>
				<input class="button primary" style="margin-left: 795px;" type="submit" value="등록" />
			</form>
		
			
	</section>
	</div>
	</div>
</body>
</html>