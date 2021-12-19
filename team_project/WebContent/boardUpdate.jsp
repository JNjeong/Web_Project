<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner">
	<section>
			<h2 class="major"style="color : #fff">글수정</h2>
			<form method="post" action="/brdUpdate.do">
			<input type="hidden" name="brdcode" id="brdcode" value=<%=request.getParameter("brdcode")%>>
			<input type="hidden" name="brdwriter" id="brdwriter" value=<%=request.getParameter("brdwriter")%>>
				<div class="fields">
					<div class="field">
						<input type="text" name="brdtitle" id="brdtitle" placeholder="title" value="<%=request.getParameter("brdtitle")%>" required/>
					</div>
					<div class="field">
						<textarea name="brdcontent" id="brdcontent" rows="10" placeholder="content"  required><%=request.getParameter("brdcontent")%></textarea>
					</div>
				</div>
				<input class="button primary fit" type="submit" value="수정하기" />
			</form>
		
			
	</section>
	</div>
	</div>
</body>
</html>