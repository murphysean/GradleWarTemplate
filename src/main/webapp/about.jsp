<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title><%= application.getInitParameter("name") %>-<%= application.getInitParameter("version") %></title>
	<%@ page import="java.util.Calendar" %>
	<meta charset="UTF-8">
</head>
<body>
	<p>Today is <%=Calendar.getInstance().getTime() %></p>
	<ul>
		<li>Name: <%= application.getInitParameter("name") %></li>
		<li>GroupId: <%= application.getInitParameter("groupId") %></li>
		<li>ArtifactId: <%= application.getInitParameter("artifactId") %></li>
		<li>Version: <%= application.getInitParameter("version") %></li>
	</ul>
</body>
</html>

