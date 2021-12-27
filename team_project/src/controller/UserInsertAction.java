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
      Boolean userIdChkResult = Boolean.parseBoolean(request.getParameter("userIdChkResult"));   //중복확인 검사 결과 받아오기
      
      System.out.println(userIdChkResult);
      
      UserVO vo = new UserVO();
      vo.setUserid(request.getParameter("userid"));
      vo.setUserpw(request.getParameter("userpw"));
      vo.setUsername(request.getParameter("username"));
      vo.setUserphone(request.getParameter("userphone"));
      vo.setUseremail(request.getParameter("useremail"));
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
       
      ActionForward forward = null;
      if(dao.UserInsert(vo, userIdChkResult)) {
            out.println("<script>alert('회원가입을 축하합니다!');location.href='/main.do';</script>");
      }
      else {
         out.println("<script>alert('등록된 아이디가 있습니다.');history.go(-1);</script>");
      }
      
      return forward;
   }

}