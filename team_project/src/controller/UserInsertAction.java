package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class UserInsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAO();
		Boolean userIdChkResult = Boolean.parseBoolean(request.getParameter("userIdChkResult"));	//중복확인 검사 결과 받아오기
		
		UserVO vo = new UserVO();
		vo.setUserid(request.getParameter("userid"));
		vo.setUserpw(request.getParameter("userpw"));
		vo.setUsername(request.getParameter("username"));
		vo.setUserphone(request.getParameter("userphone"));
		vo.setUseremail(request.getParameter("useremail"));
		
		if(dao.UserInsert(vo, userIdChkResult)) {
			System.out.println("사용자 정보 저장 성공!");
		}
		else {
			System.out.println("사용자 정보 저장 실패");		
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}
