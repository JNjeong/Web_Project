<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BCO판</title>
	<jsp:include page="head.jsp"></jsp:include>
	<title>메인</title>
</head>

<body>	

	<jsp:include page="header.jsp"></jsp:include>

	<div class="wrapper">
		<div class="inner">
		
						<section>
							<h3 class="major">비트코인 실시간 시세</h3>
							<div class="table-wrapper">
								<table class="alt">
									<colgroup><%--with처리 테스트 불필요하면 삭제--%>
										<col with="20%">
										<col with="20%">
										<col with="20%">
										<col with="20%">
										<col with="20%">
									</colgroup>
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
										<c:forEach var="coinarr" items="${coinarr}">
											<%--<c:set var="data" value="${datas.한줄한줄}" />--%>
											<tr>
												<td>${coinarr.marketname}</td>
												<td>${coinarr.coinpricekor}
													<span>KRW</span></td>
												<td>${coinarr.coinpriceeng}
													<span>USD</span></td>
												<td>${coinarr.coinrate}
													<span>${coinarr.coinratepct}%</span></td>
												<td>${coinarr.coinpremium}%</td>
												<td>${coinarr.coindeal}
													<span>BTC</span></td>
											</tr>
										</c:forEach>
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
										<c:forEach var="boardlikearr" items="${boardlikearr}">
											<tr>
												<a href="/board.do?brdcode=${boardlikearr.brdcode}">
													<td></td>
													<td>${boardlikearr.brdtitle}</td>
													<td>${boardlikearr.brdwriter}</td>
													<td>${boardlikearr.brddate}</td>
												</a>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</section>
				</div>
			</div>						
							
						<section id="footer">
							<div class="inner">
								<h2 class="major">Get in touch</h2>
								<p>Cras mattis ante fermentum, malesuada neque vitae, eleifend erat. Phasellus non pulvinar erat. Fusce tincidunt, nisl eget mattis egestas, purus ipsum consequat orci, sit amet lobortis lorem lacus in tellus. Sed ac elementum arcu. Quisque placerat auctor laoreet.</p>
								<ul class="contact">
									<li class="icon solid fa-home">
										주식회사 이조판서<br />
										서울특별시 강남구 테헤란로 26길 12 <br />
										제일비전타워 13층
									</li>
									<li class="icon solid fa-phone">(000) 000-0000</li>
								</ul>
								<ul class="contact">
									<li class="icon brands fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
									<li class="icon brands fa-facebook-f"><a href="#">facebook.com/untitled-tld</a></li>
									<li class="icon brands fa-instagram"><a href="#">instagram.com/untitled-tld</a></li>
								</ul>
								<ul class="copyright">
									<li>&copy; 이조판서 2021. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a><li>&copy; 사업자번호 : 815-88-00171</li>
								</ul>
							</div>
						</section>
						
				
				<!--  
				<ul class="pagination">
					<li><span class="button small disabled">Prev</span></li>
					<li><a href="#" class="page active">1</a></li>
					<li><a href="#" class="page">2</a></li>
					<li><a href="#" class="page">3</a></li>
					<li><span>&hellip;</span></li>
					<li><a href="#" class="page">8</a></li>
					<li><a href="#" class="page">9</a></li>
					<li><a href="#" class="page">10</a></li>
					<li><a href="#" class="button small">Next</a></li>
				</ul>
				-->
				

</body>
</html>