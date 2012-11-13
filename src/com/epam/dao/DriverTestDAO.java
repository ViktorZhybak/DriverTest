package com.epam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.epam.model.Answer;
import com.epam.model.Chapter;
import com.epam.model.Question;
import com.epam.model.Test;

public class DriverTestDAO {
	private static DriverTestDAO instance;

	private final String URL = "jdbc:postgresql://localhost/driver_test";
	private final String USER = "user";
	private final String PASSWORD = "user";

	private DriverTestDAO() {

	}

	public static synchronized DriverTestDAO getInstance() {
		if (instance == null) {
			instance = new DriverTestDAO();
		}
		return instance;
	}


	public List<Chapter> getChaptersForTest(Set<Integer> numbers) {
		List<Chapter> listOfChapters = new ArrayList<Chapter>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from chapter where chapter_id in(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			Iterator<Integer> itr = numbers.iterator();
			int i = 1;
			while (itr.hasNext()) {
				int n = itr.next();
				ps.setInt(i, n);
				i++;
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				Chapter chapter = new Chapter();
				chapter.setChapterID(rs.getInt("chapter_id"));
				chapter.setChapterTitle(rs.getString("title"));
				listOfChapters.add(chapter);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}
		return listOfChapters;
	}

	public List<Question> getRandomQuestionsByChaptersID(List<Chapter> chapters) {
		List<Question> listOfQuestions = new ArrayList<Question>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from question where chapter_id = ?";
			ps = conn.prepareStatement(sql);

			for (Chapter chapter : chapters) {
				List<Question> questions = new ArrayList<Question>();
				int chapterID = chapter.getChapterID();
				ps.setInt(1, chapterID);
				rs = ps.executeQuery();

				while (rs.next()) {
					Question question = new Question();
					question.setQuestionID(rs.getInt("question_id"));
					question.setQuestionContent(rs
							.getString("question_content"));
					questions.add(question);
				}
				Random rand = new Random();
				int n = rand.nextInt(questions.size());
				Question randomQuestion = questions.get(n);
				listOfQuestions.add(randomQuestion);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}
		return listOfQuestions;
	}

	public Map<Question, List<Answer>> getAnswersByQuestionsID(
			List<Question> questions) {
		Map<Question, List<Answer>> questionsAnswers = new LinkedHashMap<Question, List<Answer>>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from answer where question_id = ?";
			ps = conn.prepareStatement(sql);

			for (Question question : questions) {
				List<Answer> answers = new ArrayList<Answer>();
				int questionID = question.getQuestionID();
				ps.setInt(1, questionID);
				rs = ps.executeQuery();

				while (rs.next()) {
					Answer answer = new Answer();
					answer.setAnswerID(rs.getInt("answer_id"));
					answer.setAnswerContent(rs.getString("answer_content"));
					answer.setCorrect(rs.getBoolean("is_correct"));
					answers.add(answer);
				}
				questionsAnswers.put(question, answers);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}
		return questionsAnswers;
	}
	
	public void saveUsersAnswersIntoDB (Test test) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			int userID = test.getUserID();
			int testID = test.getTestID();
			String sql = "insert into test_results values (" + userID + "," + testID + ",?,?)";
			ps = conn.prepareStatement(sql);
			
			Map<Integer, Integer> mapOfUsersAnswers = test.getMapOfUsersAnswers();
			Set<Integer> questionsID = mapOfUsersAnswers.keySet();
			for (Integer questionID : questionsID) {
				int answerID = mapOfUsersAnswers.get(questionID);
				ps.setInt(1, questionID);
				ps.setInt(2, answerID);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}
	}

	public Map<Integer, Integer> getUsersAnswersFromDB(int userID, int testID) {
		Map<Integer, Integer> mapOfUsersAnswers = new TreeMap<Integer, Integer>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from test_results where users_id = ? and test_id = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, userID);
			ps.setInt(2, testID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int questionID = rs.getInt("question_id");
				int answerID = rs.getInt("answer_id");
				mapOfUsersAnswers.put(questionID, answerID);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}

		return mapOfUsersAnswers;
	}
	
	public List<Question> getQuestionsByID(Set<Integer> questionIDs) {
		List<Question> listOfQuestions = new ArrayList<Question>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from question where question_id = ?";
			ps = conn.prepareStatement(sql);

			for (Integer questionID : questionIDs) {
				ps.setInt(1, questionID);
				rs = ps.executeQuery();

				while (rs.next()) {
					Question question = new Question();
					question.setQuestionID(rs.getInt("question_id"));
					question.setQuestionContent(rs
							.getString("question_content"));
					listOfQuestions.add(question);
				}
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}
		return listOfQuestions;
	}
	
	public List<Integer> getAllUsersID() {
		List<Integer> allUsersID = new ArrayList<Integer>();
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select users_id from test_results";
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int userID = rs.getInt("users_id");
				allUsersID.add(userID);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, st, rs);
		}
		return allUsersID;
	}
	
	public List<Integer> getTestsByUserID(int userID) {
		List<Integer> allTestsByUserID = new ArrayList<Integer>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from question where question_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int testID = rs.getInt("test_id");
				allTestsByUserID.add(testID);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cleanup(conn, ps, rs);
		}
		
		return allTestsByUserID;
	}
	
	private void cleanup(Connection conn, Statement statement, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
