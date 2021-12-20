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
			case "제목" : typeDB = "brdtitle";
			case "작성자" : typeDB = "brdwriter";
			case "내용" : typeDB = "brdcontent";
			default : typeDB = "brdtitle";
		}
		String result = request.getParameter("result");
		
		ArrayList<BoardVO> boardsearcharr = dao.BrdSearchFilter(typeDB, result);
		request.setAttribute("boardsearcharr", boardsearcharr);
			
		ActionForward forward = new ActionForward();
		forward.setPath("boardlist.jsp");
		forward.setRedirect(false);
		
		return null;
	}

}
