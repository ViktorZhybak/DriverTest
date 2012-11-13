<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.epam.model.*"%>
<%@ page import="com.epam.model.viewers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question</title>
</head>
<body>

	<%
		QuestionAnswers questionAnswers =(QuestionAnswers) session.getAttribute("questionAnswers");
		Question question = questionAnswers.getQuestion(); 
		List<Answer> answers = questionAnswers.getAnswers();
	%>

	<%=question.getQuestionContent()%>
	<br>
	<form action="RunTestServlet">
	<%
		for(Iterator<Answer> it = answers.iterator(); it.hasNext();) {
			Answer answer = it.next();
			int answerID = answer.getAnswerID();
	%>
	<br>
		<input type="radio" name="usersAnswerID" value=<%=answerID%>><%=answer.getAnswerContent()%>
	<%
		}
	%>
	<br>
		<input type="submit">
	</form>
</body>
</html>