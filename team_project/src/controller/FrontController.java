package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//action값 대신할 주소 받아오기
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		String command = uri.substring(contextpath.length());
		
		request.setCharacterEncoding("UTF-8");
		
		//요청사항 파악하기
		ActionForward forward = null;
		if(command.equals("/main.do")) {
			try {
				forward = new MainAction().execute(request, response);
			}
			catch(Exception e) {
				System.out.println("FrontController에서 main 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/LoginToMain.do")) {
			try {
				forward = new LoginToMainAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 LoginToMain 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.do")) {
			try {
				forward = new LogoutAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 logout 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/idCheck.do")) {
			try {
				forward = new idCheckAction().execute(request, response); 
			}
			catch (Exception e) {
				System.out.println("FrontController에서 idCheck 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserInsert.do")) {
			try {				
				forward = new UserInsertAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 UserInsert 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardList.do")) {
			try {
				forward = new BoardListAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 boardList 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/searchList.do")) {
			try {
				forward = new SearchListAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 searchList 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/board.do")) {
			try {
				forward = new BoardAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 board 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/brdlike.do")) {
			try {
				forward = new BrdLikeAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 brdlike 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/brddislike.do")) {
			try {
				forward = new BrdDislikeAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 brddislike 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardToUpdate.do")){
			try {
				forward = new BoardToUpdateAction().execute(request, response);
			}
			catch(Exception e) {
				System.out.println("FrontController에서 boardToUpdate 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/brdUpdate.do")) {
			try {
				forward = new BrdUpdateAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 brdUpdate 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/brdDelete.do")) {
			try {
				forward = new BrdDeleteAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 brdDelete 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/cmtInsert.do")) {
			try {
				forward = new CmtInsertAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 cmtInsert 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/cmtUpdate.do")) {
			try {
				forward = new CmtUpdateAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 cmtUpdate 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/cmtDelete.do")) {
			try {
				forward = new CmtDeleteAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 cmtDelete 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardInsert.do")) {
			try {
				forward = new BoardInsertAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 boardInsert 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/mypage.do")) {
			try {
				forward = new MyPageAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 mypage 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/userUpdate.do")) {
			try {
				forward = new UserUpdateAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 userUpdate 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		else if(command.equals("/userDelete.do")) {
			try {
				forward = new UserDeleteAction().execute(request, response);
			}
			catch (Exception e) {
				System.out.println("FrontController에서 userDelete 요청중 에러 발생!");
				e.printStackTrace();
			}
		}
		
		//요청 완료 후 페이지 이동하기
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		else {
			System.out.println("FrontController 에서 forward값이 null이 되었습니다.");
		}
		
	}
	
}
