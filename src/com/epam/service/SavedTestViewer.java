package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.epam.dao.DriverTestDAO;
import com.epam.model.Answer;
import com.epam.model.DefaultAnswer;
import com.epam.model.Question;
import com.epam.model.viewers.FullResultInfoObject;

public class SavedTestViewer {
	
	public static List<FullResultInfoObject> createFullResultInfo(int userID, int testID) {
//		SavedTestViewerObject object = new SavedTestViewerObject(userID, testID);
		List<FullResultInfoObject> fullResultInfo = new ArrayList<FullResultInfoObject>();
		
		Map<Integer, Integer> mapOfUsersAnswers;
		mapOfUsersAnswers = DriverTestDAO.getInstance().getUsersAnswersFromDB(userID, testID);
		Set<Integer> questionIDs = mapOfUsersAnswers.keySet();
		List<Question> questions = DriverTestDAO.getInstance().getQuestionsByID(questionIDs);
		Map<Question, List<Answer>> questionAnswers = DriverTestDAO.getInstance().getAnswersByQuestionsID(questions);
		
		for (Question question : questions) {
			FullResultInfoObject object = new FullResultInfoObject();
			List<Answer> answers = questionAnswers.get(question);
			
			int usersAnswerID = mapOfUsersAnswers.get(question.getQuestionID());
			Answer usersAnswer = new DefaultAnswer();
			
			for (Answer answer : answers) {
				if(usersAnswerID == answer.getAnswerID()) {
					usersAnswer = answer;
				}
			}
			
			object.setQuestion(question);
			object.setAnswers(answers);
			object.setUsersAnswer(usersAnswer);
			object.setCorrect(usersAnswer.isCorrect());
			
			fullResultInfo.add(object);
		}
		return fullResultInfo;
	}
	
//	public static List<Integer> createStartInfo() {
//		List<Integer> allUsersID = DriverTestDAO.getInstance().getAllUsersID();
//		return allUsersID;
//	}
	
//	public static List<Integer> 
}
