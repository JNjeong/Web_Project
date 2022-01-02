package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comment.CommentDAO;
import model.comment.CommentVO;

public class CmtDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommentDAO dao = new CommentDAO();
		CommentVO vo = new CommentVO();
		vo.setCmtcode(Integer.parseInt(request.getParameter("cmtcode")));
		
		ActionForward forward = null;
		if(dao.CmtDelete(vo)) {
			forward = new ActionForward();
			forward.setPath("board.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("CmtDeleteAction에서 CmtDelete() 결과 : false");
		}
			
		return forward;
	}

}
