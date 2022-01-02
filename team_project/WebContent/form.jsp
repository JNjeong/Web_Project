<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/minor.css">
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="inner">
	<section>
	<%-- 
					<h2 class="major"
					style="color: #fff; font-family: 'EliceDigitalBaeum_Bold';">글
					작성</h2>
					--%>
			<form method="post" action="/boardInsert.do">
				<div class="fields" style="margin-bottom:20px">
					<div class="field">
						<input type="text" name="brdtitle" id="brdtitle" placeholder="제목" required/>
					</div>
					<div class="field">
						<textarea name="brdcontent" id="brdcontent" rows="10" placeholder="내용을 입력해주세요." required></textarea>
					</div>
				</div>
				<input class="button primary" style="margin-left: 795px;" type="submit" value="등록" />
			</form>
		
			
	</section>
	</div>
	</div>
</body>
</html>