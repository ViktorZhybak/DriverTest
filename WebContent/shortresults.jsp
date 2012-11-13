<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@page import="com.epam.model.viewers.ShortResultInfoObject"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results Of Test</title>
</head>
<body>
	<jsp:useBean id="shortResultInfo" scope="session"
		class="java.util.ArrayList" />

	<h3>Test Result</h3>
	<hr size="2">
	<table frame="below" width="100%">
		<tr>
			<th align="left">Question</th>
			<th align="left">isCorrect</th>
		</tr>
		<%
			for(Iterator<ShortResultInfoObject> it = shortResultInfo.iterator(); it.hasNext();) {
				ShortResultInfoObject ob = it.next();
		%>
		<tr>
			<td width="100"><%=ob.getQuestion().getQuestionContent()%></td>
			<td width="100"><%=ob.isCorrect()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>