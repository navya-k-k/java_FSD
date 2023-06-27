<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Vaccination Center</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1 class="center">Edit Vaccination Center</h1>
    <form action="edit-centre{id}" method="post" class="center" modelAttribute="centre">
        <input type="hidden" name="id" value="${centre.id}">
        <label for="name">Centre Name:</label>
        <input type="text" id="name" name="name" value="${centre.name}" required><br><br>

        <label for="city">Center City:</label>
        <select id="city" name="city" required>
            <c:forEach items="${cities}" var="city">
                <option value="${city}" ${city == centre.city ? 'selected="selected"' : ''}>${city}</option>
            </c:forEach>
        </select><br><br>

        <input type="submit" value="Edit">
    </form>
</body>
</html>
