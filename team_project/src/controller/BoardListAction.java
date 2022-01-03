package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardarr = dao.BrdSelectAll();

		int brdcount = boardarr.size();
		
		request.setAttribute("boardarr", boardarr);
		request.setAttribute("brdcount", brdcount);
		
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.jsp");
		forward.setRedirect(false);
	
		return forward;
	}

}
