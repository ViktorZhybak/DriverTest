<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="com.epam.model.Answer"%>
<%@page import="com.epam.model.viewers.FullResultInfoObject"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Full results of Test</title>
</head>
<body>
	<jsp:useBean id="fullResultInfo" scope="session"
		class="java.util.ArrayList" />

	<h3>Full Test Result</h3>
	<hr size="2">
	<table frame="below" width="100%">
	
		<tr>
			<th align="left">Question</th>
			<th align="left">isCorrect</th>
			<th align="left">Answers</th>
			<th align="left">UsersAnswer</th>
		</tr>
		<%
			for (Iterator<FullResultInfoObject> it = fullResultInfo.iterator(); it.hasNext();) {
				FullResultInfoObject ob = it.next();
		%>
		<tr>
		
			<td width="100"><%=ob.getQuestion().getQuestionContent()%></td>
			<td width="100"><%=ob.isCorrect()%></td>

			<td width="100">
			<%
				List<Answer> answers = ob.getAnswers();
				for (Iterator<Answer> ita = answers.iterator(); ita.hasNext();) {
					Answer answer = ita.next();
			%>
				<%=answer.getAnswerContent()%>
				<br>
			<%
				}
			%>
			</td>

			<td width="100"><%=ob.getUsersAnswer().getAnswerContent()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>
