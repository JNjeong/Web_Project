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
			<h2 class="major"style="color : #fff">글쓰기</h2>
			<form method="post" action="/boardInsert.do">
				<div class="fields">
					<div class="field">
						<input type="text" name="brdtitle" id="brdtitle" placeholder="title" required/>
					</div>
					<div class="field">
						<textarea name="brdcontent" id="brdcontent" rows="10" placeholder="content" required></textarea>
					</div>
				</div>
				<input class="button primary fit" type="submit" value="글쓰기" />
			</form>
		
			
	</section>
	</div>
	</div>
</body>
</html>