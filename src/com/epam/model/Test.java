package com.epam.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	private int userID;
	private int testID;
	private List<Chapter> listOfChapters;
	private List<Question> listOfQuestions;
	private Map<Question, List<Answer>> mapOfQuestionsAnwers;
	private Map<Integer, Integer> mapOfUsersAnswers = new HashMap<Integer, Integer>();
	private int counter = 0;
	
	public Test(int userID, int testID) {
		this.userID = userID;
		this.testID = testID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public List<Chapter> getListOfChapters() {
		return listOfChapters;
	}

	public void setListOfChapters(List<Chapter> listOfChapters) {
		this.listOfChapters = listOfChapters;
	}

	public List<Question> getListOfQuestions() {
		return listOfQuestions;
	}

	public void setListOfQuestions(List<Question> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}

	public Map<Question, List<Answer>> getMapOfQuestionsAnwers() {
		return mapOfQuestionsAnwers;
	}

	public void setMapOfQuestionsAnwers(
			Map<Question, List<Answer>> mapOfQuestionsAnwers) {
		this.mapOfQuestionsAnwers = mapOfQuestionsAnwers;
	}

	public Map<Integer, Integer> getMapOfUsersAnswers() {
		return mapOfUsersAnswers;
	}

	public void setMapOfUsersAnswers(Map<Integer, Integer> mapOfUsersAnswers) {
		this.mapOfUsersAnswers = mapOfUsersAnswers;
	}	
}
