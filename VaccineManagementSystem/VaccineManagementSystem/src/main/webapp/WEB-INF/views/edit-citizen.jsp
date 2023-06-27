<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Citizen</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .center {
            text-align: center;
        }
        .form-container {
            margin: 20px auto;
            width: 400px;
        }
        .form-container label {
            display: block;
            margin-bottom: 10px;
        }
        .form-container input,
        .form-container select {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }
        .form-container button {
            padding: 5px 10px;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <h1 class="center">Edit Citizen</h1>

    <div class="form-container">
        <form:form action="edit-citizen{id}" method="POST" modelAttribute="citizen">
         <input type="hidden" name="id" value="${citizen.id}">
            <label>Name:</label>
            <form:input path="name" />

            <label>City:</label>
            <form:select path="city" >
             <form:options items="${cities}" />
            </form:select>

            <label>Number of Doses:</label>
            <form:select path="numberOfDoses">
                <form:option value="0" label="0" />
                <form:option value="1" label="1" />
                <form:option value="2" label="2" />
            </form:select>

            <label>Vaccination Center:</label>
            <form:select path="vaccinationCenter">
                <form:options items="${vaccineCentres}" />
            </form:select>

            <button type="submit">Edit Citizen</button>
        </form:form>
    </div>
</body>
</html>
