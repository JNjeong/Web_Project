package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.BoardVO;
import model.comment.CommentDAO;
import model.comment.CommentVO;
import model.user.UserVO;

public class CmtInsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommentDAO dao = new CommentDAO();
		CommentVO vo = new CommentVO();
		
		BoardVO brdvo = new BoardVO();
		brdvo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO) session.getAttribute("currUser"); 
		
		ActionForward forward = null;
		if(dao.CmtInsert(vo, brdvo, uservo)) {
			forward = new ActionForward();
			forward.setPath("board.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("CmtInsertAction에서 CmtInsert() 결과 : false");
		}
		
		return forward;
	}

}
