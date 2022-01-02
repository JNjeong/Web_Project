package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class BrdDislikeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		
		ActionForward forward = null;
		
		if(dao.BrdDislike(vo)) {
			request.setAttribute("brdcode", vo.getBrdcode());
			
			forward = new ActionForward();
			forward.setPath("board.do");
			forward.setRedirect(false);
		}
		else {
			System.out.println("BrdDislikeAction에서 BrdDislike() 결과 : false");
		}
			
		return forward;
	}

}
