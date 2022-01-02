package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;

public class idCheckAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userid");
		
		UserDAO dao = new UserDAO();
		int idCheck = dao.UserIdChk(userId);
		
		PrintWriter out = response.getWriter();
		out.write(idCheck + "");
		
		return null;
	}

}
