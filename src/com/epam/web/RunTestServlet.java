package com.epam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.model.Test;
import com.epam.model.viewers.QuestionAnswers;
import com.epam.service.utils.QuestionAnswersUtils;
import com.epam.service.utils.ResultTestUtils;

@WebServlet("/RunTestServlet")
public class RunTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String path = "/question.jsp";
		HttpSession session = request.getSession();
		Test test = (Test) session.getAttribute("test");
		QuestionAnswers passedQuestionAnswers = (QuestionAnswers) session.getAttribute("questionAnswers");
		String usersAnswerID = request.getParameter("usersAnswerID");
		
		ResultTestUtils.saveUsersAnswersIntoTest(test, passedQuestionAnswers, usersAnswerID);

		if (passedQuestionAnswers.isLast()) {
			ResultTestUtils.saveUsersAnswersIntoDB(test);
			path = "/ShortResultsViewerServlet";
		} else {
			QuestionAnswers currentQuestionAnswers = QuestionAnswersUtils.getCurrentQuestionAnswers(test);
			session.setAttribute("questionAnswers", currentQuestionAnswers);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
