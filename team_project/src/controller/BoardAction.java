package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.comment.CommentDAO;
import model.comment.CommentVO;
import model.user.UserVO;

public class BoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO brddao = new BoardDAO();
		CommentDAO cmtdao = new CommentDAO();
						
		BoardVO brdvo = new BoardVO();
		brdvo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		
		ActionForward forward = null;
		
		//해당 게시글에 조회수 추가
		if(brddao.BrdVisited(brdvo)) {
			forward = new ActionForward();	//업데이트 성공이라면 forward를 생성, 실패라면 null로써 처리
		}
		else {
			System.out.println("BoardAction에서 BrdVisited() 결과 : false");
		}
		
		//하나의 게시글 정보 출력
		BoardVO vo = brddao.BrdSelectOne(brdvo);
		request.setAttribute("brdvo", vo);
		
		// 현재사용자 확인
		UserVO userVO = (UserVO) request.getSession().getAttribute("currUser");
		  
		if(userVO != null && vo.getBrdusercode() == userVO.getUsercode()) {
			request.setAttribute("user_eq", "T");
		}
		else request.setAttribute("user_eq", "F");
	     
	      
		//댓글 출력
		ArrayList<CommentVO> cmtarr = cmtdao.CmtSelectAll(brdvo);
		request.setAttribute("cmtarr", cmtarr);
		
		
		forward.setPath("board.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
