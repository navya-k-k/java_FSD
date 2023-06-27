<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add New Citizen</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .center {
            text-align: center;
        }
        .form {
            margin: 20px auto;
            width: 50%;
        }
        .form-group {
            margin-bottom: 10px;
        }
        .form-group label {
            display: inline-block;
            width: 150px;
            text-align: right;
        }
        .form-group select {
            width: 200px;
        }
        .btn-submit {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #333;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <h1 class="center">Add New Citizen</h1>

    

    <form action="/add-citizen" method="POST" class="form">
        <div class="form-group">
            <label for="name">Citizen Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="city">Citizen City:</label>
            <select id="city" name="city" required>
                <c:forEach items="${cities}" var="city">
                    <option value="${city}">${city}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="vaccinationCenter">Vaccination Center:</label>
            <select id="vaccinationCenter" name="vaccinationCenter" required>
                <c:forEach items="${vaccineCentres}" var="center">
                    <option value="${center}">${center}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" value="Submit" class="btn-submit">
    </form>
</body>
</html>
