package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;
import model.user.UserVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDAO dao = new UserDOA();
		
		ActionForward forward = new ActionForward();
		forward.setPath("login.jsp");
		forward.setRedirect(true);
		return forward;
	}

}
