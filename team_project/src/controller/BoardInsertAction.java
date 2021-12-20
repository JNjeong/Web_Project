package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.user.UserVO;

public class BoardInsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO) session.getAttribute("currUser");

		vo.setBrdtitle(request.getParameter("brdtitle"));
		vo.setBrdwriter(uservo.getUsername());
		vo.setBrdcontent(request.getParameter("brdcontent"));
		
		
		ActionForward forward = null;
		if(dao.BrdInsert(vo, uservo)) {
			forward = new ActionForward();
			forward.setPath("boardlist.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("BoardInsertAction에서 BrdInsert() 결과 : false");
		}
				
		return forward;
	}
	
}
