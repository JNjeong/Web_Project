package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class LoginToMainAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      UserDAO dao = new UserDAO();
      
      //로그인시 넘어오는 아이디, 비밀번호 받아오기
      String userid = request.getParameter("userid");   
      String userpw = request.getParameter("userpw");
      UserVO vo = dao.UserSelectOne(userid, userpw);   //아이디와 비밀번호에 맞는 사용자 정보 반환
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
    
      ActionForward forward = null;

      if(vo != null) {
         HttpSession session = request.getSession();
         session.setAttribute("currUser", vo);   //세선에 사용자 정보 저장
         
         forward = new ActionForward();
         forward.setPath("main.do");
         forward.setRedirect(false);
      }
      else {
         out.println("<script>alert('아이디와 비밀번호가 일치하지 않습니다.');history.go(-1);</script>");
      }
      return forward;
   }

}