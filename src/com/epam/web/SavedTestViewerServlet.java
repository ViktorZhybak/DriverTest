package com.epam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.dao.DriverTestDAO;

@WebServlet("/SavedTestViewerServlet")
public class SavedTestViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		if (userID == null) {
			List<Integer> allUsersID = DriverTestDAO.getInstance().getAllUsersID();
			session.setAttribute("allUsersID", allUsersID);
			request.getRequestDispatcher("/userform.jsp").forward(request, response);
		} else {
			int intUserID = Integer.parseInt(userID);
			List<Integer> testsByUserID = DriverTestDAO.getInstance().getTestsByUserID(intUserID);
			
			session.setAttribute("testIDs", testsByUserID);
			session.setAttribute("userID", intUserID);
			request.getRequestDispatcher("/testform.jsp").forward(request, response);
		}
	}
}
