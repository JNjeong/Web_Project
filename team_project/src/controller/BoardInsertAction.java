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

		System.out.println("BoardInsertAction 입장");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		System.out.println("Board 객체들 생성");
		
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO) session.getAttribute("currUser");
		
		System.out.println("User 정보 session에서 받아오기");

		vo.setBrdtitle(request.getParameter("brdtitle"));
		vo.setBrdwriter(uservo.getUsername());
		vo.setBrdcontent(request.getParameter("brdcontent"));
		
		System.out.println("board객체에 값 대입하기");
		
		ActionForward forward = null;
		System.out.println("forward 객체생성");
		
		if(dao.BrdInsert(vo, uservo)) {
			System.out.println("dao에서 brdinsert 실행입장");
			forward = new ActionForward();
			forward.setPath("boardList.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("BoardInsertAction에서 BrdInsert() 결과 : false");
		}
				
		return forward;
	}
	
}
