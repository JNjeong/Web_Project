package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserVO;

public class MyPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("currUser");
		
		ActionForward forward = null;
		if(vo != null) {
			forward = new ActionForward();
			forward.setPath("mypage.jsp");
			forward.setRedirect(false);
		}
	
		return forward;
	}

}
