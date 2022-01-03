<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/minor.css">
<head>
   <jsp:include page="head.jsp"></jsp:include>
   <title>BCO판</title>
</head>


<body>

   <jsp:include page="header.jsp"></jsp:include>

   <img alt="코인사진" src="/images/bitcoin.jpg" style="position:absolute; width:100%; height:800px;">
   <div class="wrapper">
      <div class="inner" style="margin-top: 700px !important;">

                  <section style="margin-bottom : 100px;">
                     <h3 class="colorgold" style="color:white; font-family:'EliceDigitalBaeum_Bold'; font-size:26px; margin-bottom: 22px;">비트코인 실시간 시세</h3>
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
                                 <tr>
                                    <td>${coinarr.marketname}</td>
                                    <td><fmt:formatNumber value="${coinarr.coinpricekor}"/>
                                       <span>KRW</span></td>
                                    <td><fmt:formatNumber value="${coinarr.coinpriceeng}"/>
                                       <span>USD</span></td>
                                    <td><fmt:formatNumber value="${coinarr.coinrate}"/>
                                       <span style="float :right; ">${coinarr.coinratepct}%</span></td>
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
                     <h3 class="colorgold" style="color:white; font-family:'EliceDigitalBaeum_Bold'; font-size:26px; margin-bottom: 22px;">인기 게시글</h3>
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
                              <c:forEach var="boardlikearr" items="${boardlikearr}" varStatus="status">
                                    <tr onclick="location.href='/board.do?brdcode=${boardlikearr.brdcode}'" style="cursor:pointer">
                                       <td><c:out value = "${status.count}"/></td>
                                       <td>${boardlikearr.brdtitle}</td>
                                       <td>${boardlikearr.brdwriter}</td>
                                       <td>${boardlikearr.brddate}</td>
                                    </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>
                  </section>

                  <jsp:include page="footer.jsp"/>
            
            </div>
         </div>
</body>
</html>