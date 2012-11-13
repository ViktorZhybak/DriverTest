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
import com.epam.service.utils.TestUtils;

@WebServlet("/StartTestServlet")
public class StartTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Test test = TestUtils.createTest(101, 11);
		QuestionAnswers currentQuestionAnswers = QuestionAnswersUtils.getCurrentQuestionAnswers(test);

		HttpSession session = request.getSession();
		session.setAttribute("test", test);
		session.setAttribute("questionAnswers", currentQuestionAnswers);
		request.getRequestDispatcher("/question.jsp").forward(request, response);
	}
}
