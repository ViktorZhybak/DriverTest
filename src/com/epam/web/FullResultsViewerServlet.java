package com.epam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.model.Test;
import com.epam.model.viewers.FullResultInfoObject;
import com.epam.model.viewers.ShortResultInfoObject;
import com.epam.service.FullResultViewer;

@WebServlet("/FullResultsViewerServlet")
public class FullResultsViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Test test = (Test) session.getAttribute("test");
		List<ShortResultInfoObject> shortResultInfo = (List<ShortResultInfoObject>) session.getAttribute("shortResultInfo");
		
		List<FullResultInfoObject> fullResultInfo = FullResultViewer.viewFullResult(test, shortResultInfo);
		
		session.setAttribute("fullResultInfo", fullResultInfo);
		request.getRequestDispatcher("/fullresults.jsp").forward(request, response);
	}
}
