package com.epam.model;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
	private int chapterID;
	private String chapterTitle;
	List<Question> listOfQuestions = new ArrayList<Question>();

	public int getChapterID() {
		return chapterID;
	}

	public void setChapterID(int chapterID) {
		this.chapterID = chapterID;
	}

	public List<Question> getListOfQuestions() {
		return listOfQuestions;
	}

	public void setListOfQuestions(List<Question> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	@Override
	public String toString() {
		return "Chapter [chapterID=" + chapterID + ", chapterTitle="
				+ chapterTitle + "]";
	}
	
}
