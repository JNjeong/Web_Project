<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
const checkDeleteBoard = function() {
	var result = confirm("정말 글을 삭제 하시겠습니까?");
	 if(result){
	     location.href="/brdDelete.do?brdcode="+${brdvo.brdcode};
	 }else return;
}

$(function(){
	   $(".submitbtn").click(function(){

	      if($(this).find("#editCmt").text() == "수정완료"){
	         $(this).siblings().find('#cmtcommentbox').attr('readonly', true);
	         $(this).siblings().find('#cmtcommentbox').css('background-color','#f5f5f5');   
	         $(this).find("#editCmt").text('수정');
	         $(this).parent("#cmtUpdate-form").submit();
	      }
	      else if($(this).find("#editCmt").text() =="수정"){
	         $(this).siblings().find('#cmtcommentbox').attr('readonly', false);
	         $(this).siblings().find('#cmtcommentbox').css('background-color','#fff');
	         $(this).find("#editCmt").text('수정완료');
	      }
	   });
});$(function(){
	$("#submitComment").click(function(){
		 if("${currUser.usercode}"==""){
			alert('로그인 후 이용가능합니다.');
			return false;
		}
		else {
			$("#commentForm").submit();
		}
	});
});
$(function(){
	   
	   $("#goBack").click(function(){
	      
	      console.log("${currUser.usercode}");
	      if("${currUser.usercode}"==""){
	         alert('로그인 후 이용가능합니다.');
	         return;
	      }
	      
	      location.href= "boardList.do";
	   });
});
</script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		
		<div class="wrapper">
			<div class="inner">
			<form action="boardUpdate.jsp" method="post">
				<div class="table-wrapper">
					<h2 style="color: #fff">
						<input style="font-family: 'EliceDigitalBaeum_Bold'; font-size:26px;" type="text" name="brdtitle" value="${brdvo.brdtitle}"	readonly />
					</h2>
					<h5 style="color: #fff; font-family:'EliceDigitalBaeum_Bold'; float: right;">
						조회수 ${brdvo.brdvisited} | 좋아요 ${brdvo.brdlike} | 싫어요 ${brdvo.brddislike}
					</h5>
					<table style="border: 2px solid rgba(255, 255, 255, 0.125); border-radius: 5px; margin: 0 0 0 0; background-color: rgba(255, 255, 255, 0.025);" class = "alt">
						<colgroup>
							<col width= "89%">
							<col width= "11%">
						</colgroup>
						<thead>
							<tr>
								<th style="padding: 0.5em 0.75em 0.5em 1.1em; font-size: 0.9em;">${brdvo.brdwriter}</th>
								<th style="padding: 0.5em 0.75em 0.5em 0.75em; font-size: 0.9em;">${brdvo.brddate}</th>
							</tr>
						</thead>
					</table>
					<input type="hidden" value="${brdvo.brdcode}" name="brdcode" />
					<textarea name="brdcontent" id="brdcontent" rows="15" readonly="readonly">${brdvo.brdcontent}</textarea>

					
					<div style="float:right; margin-top: 10px;margin-left:10px;">
						<a href="#" class="button primary" id="goBack">뒤로가기</a>
					</div>
				
				<c:if test="${user_eq eq 'F'}">
					<c:if test="${not empty currUser}">	
						<div style="display:inline-block;">
							<a href="/brdlike.do?brdcode=${brdvo.brdcode}" style="display:inline-block; margin-right: 10px;"><i class="fas fa-thumbs-up"></i><span>${brdvo.brdlike}명이 추천해요!</span></a>
							<a href="/brddislike.do?brdcode=${brdvo.brdcode}" style="display:inline-block;"><i class="fas fa-thumbs-down"></i><span>${brdvo.brddislike}명이 비추천해요!</span></a>
						</div>
					</c:if>
				</c:if>
					
					
				<c:if test="${user_eq == 'T'}">
                  <div style="float:right; margin-top: 10px;margin-left:10px;">
                     <input type="submit" class="button primary" value="수정" style="display:inline-block;">
                     <a href="#" onclick="checkDeleteBoard()" class="button primary" style="display:inline-block;">삭제</a>
                  </div>
               </c:if>
					
					</div>
				</form>
			</div>
		</div>
		
		
		
<div class="container">
  <div class="row">
    <div class="col-sm-10 col-sm-offset-1" id="logout" style="color:black;">
        <div class="comment-tabs">
            <ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#comments-logout" role="tab" data-toggle="tab"><h4 class="reviews text-capitalize" style="font-family:'EliceDigitalBaeum_Bold'; font-size:18px;">Comments</h4></a></li>
                <li><a href="#account-settings" role="tab" data-toggle="tab"><h4 class="reviews text-capitalize" style="font-family:'EliceDigitalBaeum_Bold'; font-size:18px;">Add Comment</h4></a></li>
            </ul>           
            <div class="tab-content">
                <div class="tab-pane active" id="comments-logout">                
                    <ul class="media-list">
				      	<c:forEach items="${cmtarr}" var="cmtarr">
				      		<li class="media">
					          <div class="media-body">
					            <div class="well well-lg">
					            	<form id="cmtUpdate-form" action="/cmtUpdate.do?brdcode=${brdvo.brdcode}" method="post">
					            	<input type="hidden" name="cmtcode" value="${cmtarr.cmtcode}"/>
					                <h4 class="media-heading text-uppercase reviews" style="font-family:'EliceDigitalBaeum_Bold';">${cmtarr.cmtwriter}님</h4>
					                <p class="media-comment">
					                  <textarea rows="" cols="" id="cmtcommentbox" name="cmtcontent" readonly>${cmtarr.cmtcontent}</textarea>
					                </p>
					                <c:if test="${currUser.usercode==cmtarr.cmtusercode}">
					                	<a class="btn btn-info btn-circle text-uppercase submitbtn"><span class="glyphicon glyphicon-share-alt"></span><span id="editCmt">수정</span></a>	                
					                	<a class="btn btn-info btn-circle text-uppercase" href="/cmtDelete.do?cmtcode=${cmtarr.cmtcode}&brdcode=${brdvo.brdcode}" id="reply"><span class="glyphicon glyphicon-share-alt"></span> 삭제</a>
					                </c:if>
					            </form>	
					            </div>              
					          </div>
				         	</li>
				      	</c:forEach>
      				 </ul> 
                </div>

                <div class="tab-pane" id="account-settings">
                    <form action="/cmtInsert.do" method="post" class="form-horizontal" id="commentForm" role="form"> 
                        <input type="hidden" value="${brdvo.brdcode}" name="brdcode">
                        <input type="hidden" value="${brdvo.brdwriter}" name="brdwriter">
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Comment</label>
                            <div class="col-sm-10">
                              <textarea class="form-control" name="cmtcontent" id="addComment" rows="5" style="margin-top : 15px;" required></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">                    
                                <button class="btn btn-success btn-circle text-uppercase" id="submitComment"><span class="glyphicon glyphicon-send"></span> Submit comment</button>
                            </div>
                        </div>            
                    </form>
                </div>
            </div>
        </div>
	</div>
  </div>
</div>

<div class="wrapper"></div>
<div style="background-color: #2e3141">
	<jsp:include page="footer.jsp"/>
</div>


</body>
</html>