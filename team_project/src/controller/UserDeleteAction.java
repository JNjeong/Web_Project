package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class UserDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAO();
		HttpSession session = request.getSession();
		UserVO currUser = (UserVO) session.getAttribute("currUser");
		
		UserVO vo = new UserVO();
		vo.setUsercode(currUser.getUsercode());
		
		ActionForward forward = null;
		
		if(dao.UserDelete(vo)) {
			session.invalidate(); 		//세선에 담긴 사용자 정보 비우기
			
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		else {
			System.out.println("UserDeleteAction에서 UserDelete()결과 : false");
		}
		
		return forward;
	}

}
