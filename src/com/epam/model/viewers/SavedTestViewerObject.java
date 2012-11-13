package com.epam.model.viewers;

import java.util.Map;

public class SavedTestViewerObject {
	int userID;
	int testID;
	Map<Integer, Integer> mapOfUsersAnswers;
	
	public SavedTestViewerObject(int userID, int testID) {
		this.userID = userID;
		this.testID = testID;
	}
	
}
