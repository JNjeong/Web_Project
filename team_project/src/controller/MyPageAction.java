package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class MyPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAO();
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("currUser");
		
		UserVO voAll = dao.UserSelectOne(vo);
		
		request.setAttribute("uservo", voAll);
		
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
