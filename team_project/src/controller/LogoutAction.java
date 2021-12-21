package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); //현재 세션 정보 받아오기
		session.invalidate(); //세선에 담긴 모든 정보 삭제
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}
