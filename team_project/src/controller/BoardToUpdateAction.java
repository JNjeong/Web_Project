package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardToUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//board.jsp에서 받아온 값을 그대로 boardUpdate.jsp로 이전
		//해당 페이지는 V->V로 값을 이전하는 코드가 작성되어있으므로, 해당 코드 사용을 위해 request로 그대로 옮겨주었음.
		request.setAttribute("brdtitle", request.getAttribute("brdtitle"));
		request.setAttribute("brdcode", request.getAttribute("brdcode"));
		request.setAttribute("brdwriter", request.getAttribute("brdwriter"));
		request.setAttribute("brdlike", request.getAttribute("brdlike"));
		request.setAttribute("brddislike", request.getAttribute("brddislike"));
		request.setAttribute("brdvisited", request.getAttribute("brdvisited"));
		request.setAttribute("brddate", request.getAttribute("brddate"));
		request.setAttribute("brdcontent", request.getAttribute("brdcontent"));
		
		ActionForward forward = new ActionForward();
		forward.setPath("boardUpdate.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
