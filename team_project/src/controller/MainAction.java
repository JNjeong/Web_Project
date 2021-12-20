package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.coin.CoinDAO;
import model.coin.CoinVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//코인판 정보 받아오기
		CoinDAO coindao = new CoinDAO();
		ArrayList<CoinVO> coinarr = coindao.CoinSelet();
		request.setAttribute("coinarr", coinarr);
		
		//좋아요 된 게시글 받아오기
		BoardDAO boarddao = new BoardDAO();
		ArrayList<BoardVO> boardlikearr = boarddao.BrdLikeFilter();
		request.setAttribute("boardlikearr", boardlikearr);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
