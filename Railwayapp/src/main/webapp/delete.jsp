<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.servlet.*" %>
    <%@page import="com.railway.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CrossingDAO dao=new CrossingDAO();
	int rid=Integer.parseInt(request.getParameter("rid"));
	Crossing c=new Crossing();
	c.setRid(rid);
	dao.delete(c);
	response.sendRedirect("admin-dashboard.jsp");

	%>
		    
</body>
</html>