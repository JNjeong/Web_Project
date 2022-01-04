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
		request.setCharacterEncoding("UTF-8");
		
		CommentDAO dao = new CommentDAO();
		CommentVO vo = new CommentVO();
		vo.setCmtcontent(request.getParameter("cmtcontent"));
		
		BoardVO brdvo = new BoardVO();
		brdvo.setBrdcode(Integer.parseInt(request.getParameter("brdcode")));
		
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO) session.getAttribute("currUser"); 		
		
		ActionForward forward = null;
		
		if(dao.CmtInsert(vo, brdvo, uservo)) {
			System.out.println("함수 성공적으로 실행 완료");
			
			request.setAttribute("brdcode", brdvo.getBrdcode());
			System.out.println("댓글다는중");
			
			forward = new ActionForward();
			forward.setPath("board.do?brdcode="+Integer.parseInt(request.getParameter("brdcode")));
			forward.setRedirect(true);
		}
		else {
			System.out.println("CmtInsertAction에서 CmtInsert() 결과 : false");
		}
		
		return forward;
	}

}
