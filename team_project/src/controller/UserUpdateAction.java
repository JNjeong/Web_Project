package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class UserUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		
		//세션에 저장된 사용자의 코드만을 받아오기
		HttpSession session = request.getSession();
		UserVO currUser = (UserVO) session.getAttribute("currUser");
		
		//업데이트 한 사용자 정보 받아오기
		vo.setUsercode(currUser.getUsercode());
		vo.setUserid(currUser.getUserid());
		vo.setUserpw(request.getParameter("userpw"));
		vo.setUsername(request.getParameter("username"));
		vo.setUserphone(request.getParameter("userphone"));
		vo.setUseremail(request.getParameter("useremail"));
		
		ActionForward forward = null;
		
		if(dao.UserUpdate(vo)) {
			session.setAttribute("currUser", vo); 	//업데이트 성공했으면 그 정보를 그대로  session에 저장해주기
			forward = new ActionForward();
			forward.setPath("mypage.jsp");
			forward.setRedirect(false);
		}
		else {
			System.out.println("UserUpdateAction에서 UserUpdate() 결과 : false");
		}
	
		return forward;
	}
	
}
