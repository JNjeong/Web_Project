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

public class BoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO brddao = new BoardDAO();
		CommentDAO cmtdao = new CommentDAO();
		
		//하나의 게시글 정보 출력
		BoardVO brdvo = new BoardVO();
		brdvo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		
		BoardVO vo = brddao.BrdSelectOne(brdvo);
		request.setAttribute("brdvo", vo);
		
		//댓글 출력
		ArrayList<CommentVO> cmtarr = cmtdao.CmtSelectAll(brdvo);
		request.setAttribute("cmtarr", cmtarr);
		
		ActionForward forward = new ActionForward();
		forward.setPath("board.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
