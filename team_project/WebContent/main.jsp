<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="head.jsp"></jsp:include>
	<title>메인</title>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="wrapper">
		<div class="inner">
		
			<section class="coin_crolling">
				<h3 class="major">코인</h3>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>거래소</th>
								<th>실시간 시세(kRW)</th>
								<th>실시간 시세(USD)</th>
								<th>24시간 변동률</th>
								<th>한국 프리미엄</th>
								<th>거래량</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>61,414,000 KRW</td>
								<td>52,001.69 USD</td>
								<td>
									<ul>
										<li>1,240,000</li>
										<li>+ 2.14%</li>
									</ul>
								</td>
								<td>
									<ul>
										<li>1,240,000</li>
										<li>+ 2.14%</li>
									</ul>
								</td>
								<td>1,126 BTC</td>
							</tr>
							<tr>
								<td>61,414,000 KRW</td>
								<td>52,001.69 USD</td>
								<td>
									<ul>
										<li>1,240,000</li>
										<li>+ 2.14%</li>
									</ul>
								</td>
								<td>
									<ul>
										<li>1,240,000</li>
										<li>+ 2.14%</li>
									</ul>
								</td>
								<td>1,126 BTC</td>
							</tr>
							<tr>
								<td>61,414,000 KRW</td>
								<td>52,001.69 USD</td>
								<td>
									<ul>
										<li>1,240,000</li>
										<li>+ 2.14%</li>
									</ul>
								</td>
								<td>
									<ul>
										<li>1,240,000</li>
										<li>+ 2.14%</li>
									</ul>
								</td>
								<td>1,126 BTC</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
		
			<section class="fav_board">
				<h3 class="major">인기 게시판</h3>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>Number</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Morbi faucibus arcu accumsan lorem.</td>
								<td>김종범님</td>
								<td>2021-12-12</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Morbi faucibus arcu accumsan lorem.</td>
								<td>김종범님</td>
								<td>2021-12-12</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Morbi faucibus arcu accumsan lorem.</td>
								<td>김종범님</td>
								<td>2021-12-12</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Morbi faucibus arcu accumsan lorem.</td>
								<td>김종범님</td>
								<td>2021-12-12</td>
							</tr>
						</tbody>
					</table>
				</div>
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
			</section>
		</div>
	</div>
</body>
</html>