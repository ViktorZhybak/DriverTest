package com.epam.service.utils;

import com.epam.dao.DriverTestDAO;
import com.epam.model.Question;
import com.epam.model.Test;
import com.epam.model.viewers.QuestionAnswers;

public class ResultTestUtils {
	
	public static void saveUsersAnswersIntoTest(Test test, QuestionAnswers passedQuestionAnswers, String string) {
		
		Question question = passedQuestionAnswers.getQuestion();
		int passQuestionID = question.getQuestionID();
		System.out.println("string: " + string);
		int usersAnswerID = 0;
		if(string != null) {
			usersAnswerID = Integer.parseInt(string);
		}
		TestUtils.fillMapOfResult(test, passQuestionID, usersAnswerID);
	}
	
	public static void saveUsersAnswersIntoDB(Test test) {
		DriverTestDAO.getInstance().saveUsersAnswersIntoDB(test);
	}
}
