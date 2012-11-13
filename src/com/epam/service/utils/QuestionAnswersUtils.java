package com.epam.service.utils;

import java.util.List;

import com.epam.model.Answer;
import com.epam.model.Question;
import com.epam.model.Test;
import com.epam.model.viewers.QuestionAnswers;

public class QuestionAnswersUtils {

	public static QuestionAnswers getCurrentQuestionAnswers(Test test) {
		
		Question currentQuestion = TestUtils.getCurrentQuestion(test);
		List<Answer> currentAnswers = TestUtils.getAnswersByCurrentQuestion(test, currentQuestion);

		QuestionAnswers currentQuestionAnswers = new QuestionAnswers();
		currentQuestionAnswers.setQuestion(currentQuestion);
		currentQuestionAnswers.setAnswers(currentAnswers);
		currentQuestionAnswers.setLast(TestUtils.isLastQuestion(test));
		TestUtils.gotoNextQuestion(test);
		
		return currentQuestionAnswers;
	}
}
