<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE HTML>
<html>
	<head>
		<title>프로젝트 이름</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<jsp:include page="head.jsp"></jsp:include>
	</head>
	<body class="is-preload">

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="main.jsp">프로젝트 이름</a></h1>
						<nav>
							<a href="#menu">Menu</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<div class="inner">
							<h2>Menu</h2>
							<ul class="links">
								<li><a href="main.jsp">Home</a></li>
								<li><a href="login.jsp">Log In</a></li>
								<li><a href="signup.jsp">Sign Up</a></li>
							</ul>
							<a href="#" class="close">Close</a>
						</div>
					</nav>

				<!-- Wrapper -->
					<section id="wrapper">
						<header>
							<div class="inner">
								<h2>비코판 자리</h2>
							</div>
						</header>

						<!-- Content -->
							<div class="wrapper">
								<div class="inner">

									<section>
										<ul class="actions fit">
											<li><a href="#" class="button primary fit">Main</a></li>
											<li><a href="#" class="button fit">자유게시판</a></li>
											<li><a href="#" class="button fit">My page</a></li>
										</ul>
									</section>

									<section>
										<h3 class="major">비트코인 실시간 시세</h3>
										<div class="table-wrapper">
											<table class="alt">
												<thead>
													<tr>
														<th>거래소</th>
														<th>실시간 시세(KRW)</th>
														<th>실시간 시세(USD)</th>
														<th>24시간 변동률</th>
														<th>한국 프리미엄</th>
														<th>거래량</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>업비트</td>
														<td>100</td>
														<td>100</td>
														<td>100%</td>
														<td>10%</td>
														<td>10</td>
													</tr>
													<tr>
														<td>빗썸</td>
														<td>100</td>
														<td>100</td>
														<td>100%</td>
														<td>10%</td>
														<td>10</td>
													</tr>
													<tr>
														<td>바이낸스</td>
														<td>100</td>
														<td>100</td>
														<td>100%</td>
														<td>-</td>
														<td>10</td>
													</tr>
												</tbody>
											</table>
										</div>
									</section>
									
									<section>
										<h3 class="major">인기 게시글</h3>
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
													<tr>
														<td>1</td>
														<td>제목이다</td>
														<td>노원재</td>
														<td>2021.12.01</td>
													</tr>
													<tr>
														<td>2</td>
														<td>제목이다</td>
														<td>노원재</td>
														<td>2021.12.01</td>
													</tr>
													<tr>
														<td>3</td>
														<td>제목이다</td>
														<td>노원재</td>
														<td>2021.12.01</td>
													</tr>
												</tbody>
											</table>
										</div>
									</section>
									
								</div>
							</div>
					</section>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>