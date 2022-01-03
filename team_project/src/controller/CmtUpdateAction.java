package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comment.CommentDAO;
import model.comment.CommentVO;

public class CmtUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommentDAO dao = new CommentDAO();
		CommentVO vo = new CommentVO();
		vo.setCmtcode(Integer.parseInt(request.getParameter("cmtcode")));
		vo.setCmtcontent(request.getParameter("cmtcontent"));
		
		ActionForward forward = null;
		if(dao.CmtUpdate(vo)) {
			forward = new ActionForward();
			forward.setPath("/board.do?brdcode="+Integer.parseInt(request.getParameter("brdcode")));			
			forward.setRedirect(true);
		}
		else {
			System.out.println("CmtUpdateAction에서 CmtUpdate() 결과 : false");
		}
		
		return forward;
	}

}
