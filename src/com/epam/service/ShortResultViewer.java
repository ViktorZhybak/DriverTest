package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.model.Answer;
import com.epam.model.Question;
import com.epam.model.Test;
import com.epam.model.viewers.ShortResultInfoObject;

public class ShortResultViewer {
	
	public static List<ShortResultInfoObject> viewShortResult(Test test) {
		List<ShortResultInfoObject> shortResultInfo = new ArrayList<ShortResultInfoObject>();
		Map<Integer, Integer> mapOfUsersAnswers = test.getMapOfUsersAnswers();
		Map<Question, List<Answer>> mapOfQuestionsAnwers = test
				.getMapOfQuestionsAnwers();

		List<Question> questions = test.getListOfQuestions();
		for (Question question : questions) {

			ShortResultInfoObject shortResultInfoObject = new ShortResultInfoObject();

			int wrightAnswerID = 0;

			List<Answer> listOfAnswers = mapOfQuestionsAnwers.get(question);
			for (Answer answer : listOfAnswers) {
				if (answer.isCorrect()) {
					wrightAnswerID = answer.getAnswerID();
				}
			}

			int questionID = question.getQuestionID();
			int usersAnswerID = mapOfUsersAnswers.get(questionID);

			shortResultInfoObject.setQuestion(question);
			if (wrightAnswerID == usersAnswerID) {
				shortResultInfoObject.setCorrect(true);
			} else {
				shortResultInfoObject.setCorrect(false);
			}

			shortResultInfo.add(shortResultInfoObject);
		}
		return shortResultInfo;
	}
}
