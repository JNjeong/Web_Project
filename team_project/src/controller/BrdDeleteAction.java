package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class BrdDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		
		ActionForward forward = null;
		if(dao.BrdDelete(vo)) {
			forward = new ActionForward();
			forward.setPath("boardList.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("BrdDeleteAction에서 BrdDelete() 결과 : false");
		}
		
		return forward;
	}

}
