package com.epam.service.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.epam.dao.DriverTestDAO;
import com.epam.model.Answer;
import com.epam.model.Chapter;
import com.epam.model.Question;
import com.epam.model.Test;
import com.epam.service.NumbersGenerator;

public class TestUtils {

	public static Test createTest(int userID, int testID) {
		Test test = new Test(userID, testID);
		fillTestByRandomChapters(test);
		fillTestByRandomQuestions(test);
		fillTestByAnswers(test);
		return test;
	}

	public static void fillTestByRandomChapters(Test test) {
		NumbersGenerator generator = new NumbersGenerator();
		Set<Integer> randomNumbers = generator.createRandomNumbers();

		List<Chapter> chaptersInTest = DriverTestDAO.getInstance()
				.getChaptersForTest(randomNumbers);
		test.setListOfChapters(chaptersInTest);
	}

	public static void fillTestByRandomQuestions( Test test) {
		List<Chapter> chapters = test.getListOfChapters();
		List<Question> listOfRandomQuestions = DriverTestDAO.getInstance()
				.getRandomQuestionsByChaptersID(chapters);
		test.setListOfQuestions(listOfRandomQuestions);
	}

	public static void fillTestByAnswers(Test test) {
		List<Question> questions = test.getListOfQuestions();
		Map<Question, List<Answer>> mapOfQuestionsAnwers;
		mapOfQuestionsAnwers = DriverTestDAO.getInstance()
				.getAnswersByQuestionsID(questions);
		test.setMapOfQuestionsAnwers(mapOfQuestionsAnwers);
	}
	
	public static Question getCurrentQuestion(Test test) {
		Question result = null;
		int counter = test.getCounter();
		List<Question> listOfQuestions = test.getListOfQuestions();
		
		if (counter < listOfQuestions.size()) {
			result = listOfQuestions.get(counter);
		}
		return result;
	}
	
	public static List<Answer> getAnswersByCurrentQuestion(Test test, Question question) {
		List<Answer> answers = test.getMapOfQuestionsAnwers().get(question);		
		return answers;
	}

	public static boolean isLastQuestion(Test test) {
		return test.getCounter() == (test.getListOfQuestions().size()-1);
	}
	
	public static void gotoNextQuestion(Test test) {
		int counter = test.getCounter();
		test.setCounter(++counter);
	}
	
	public static void fillMapOfResult(Test test, int questionID, int answerID) {
		Map<Integer, Integer> result  = new HashMap<Integer, Integer>();
		result = test.getMapOfUsersAnswers();
		result.put(questionID, answerID);
	}
}
