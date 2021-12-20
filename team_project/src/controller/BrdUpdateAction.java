package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class BrdUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		vo.setBrdtitle(request.getParameter("brdtitle"));
		vo.setBrdcontent(request.getParameter("brdcontent"));
		
		ActionForward forward = null;
		if(dao.BrdUpdate(vo)) {
			request.setAttribute("brdcode", vo.getBrdcode());
			
			forward = new ActionForward();
			forward.setPath("board.do");
			forward.setRedirect(false);
		}
		else {
			System.out.println("BrdUpdateAction에서 BrdUpdate() 결과 : false");
		}
		
		return forward;
	}

}
