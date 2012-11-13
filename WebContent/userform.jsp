<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
</head>
<body>
	<jsp:useBean id="allUsersID" scope="session"
		class="java.util.ArrayList" />
	

	<form action="/SavedTestViewerServlet">
		<select name="userID">
			<%
				for (Iterator<Integer> it = allUsersID.iterator(); it.hasNext();) {
					int userID = it.next();
			%>
			<option value=userID><%=userID%></option>
			<%
				}
			%>

		</select> <input type="submit" />
	</form>

</body>
</html>