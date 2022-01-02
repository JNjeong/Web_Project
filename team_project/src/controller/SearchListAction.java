package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class SearchListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		String typeKor = request.getParameter("type");
		String typeDB = "";
		switch(typeKor){
			case "제목" : typeDB = "BRDTITLE"; break;
			case "작성자" : typeDB = "BRDWRITER"; break;
			case "내용" : typeDB = "BRDCONTENT"; break;
			default : typeDB = "BRDTITLE";
		}
		String result = request.getParameter("result");
		ArrayList<BoardVO> boardarr = dao.BrdSearchFilter(typeDB, result);
		int brdcount = boardarr.size();
		
		request.setAttribute("boardarr", boardarr);
		request.setAttribute("brdcount", brdcount);
		
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
