package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;
import model.user.UserVO;

public class SignToMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAO();
		ArrayList<UserVO> userarr = dao.UserSelectAll();
		request.setAttribute("userarr", userarr); //중복체크시에 사용할 userlist를 보냄
		
		ActionForward forward = new ActionForward();
		forward.setPath("sign.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
