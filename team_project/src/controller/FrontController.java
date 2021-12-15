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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//action값 대신할 주소 받아오기
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		String command = uri.substring(contextpath.length());
		
		//요청사항 파악하기
		ActionForward forward = null;
		if(command.equals("")) {
			try {
				
			}
			catch(Exception e) {
				System.out.println("FrontController에서 OO 요청중 에러 발생!");
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
		
	}
	
}
