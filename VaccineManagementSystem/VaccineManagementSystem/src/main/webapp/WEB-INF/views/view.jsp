
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Vaccination Centre</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .center {
            text-align: center;
        }
        .table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
        }
        .table th,
        .table td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        .table th {
            background-color: #f2f2f2;
        }
        .btn {
            display: inline-block;
            padding: 5px 10px;
            text-decoration: none;
            color: #fff;
            background-color: #333;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <h1 class="center">View Vaccination Centre</h1>

    <div class="center">
        <a href="/citizens" class="btn">Citizens</a>
        <a href="/vaccinationcentre" class="btn">Vaccination Centers</a>
        <a href="/login" class="btn">Logout</a>
    </div>

    <h2 class="center">Center Information</h2>
    <table class="table center">
        <thead>
            <tr>
                <th>${centre.name}</th>
            </tr>
        </thead>
        <tbody>
            
            <tr>
                <td>ID: ${centre.id}</td>
            </tr>
            <tr>
                <td>City: ${centre.city}</td>
            </tr>
        </tbody>
    </table>
    
    <%-- <h2 class="center">Citizens</h2>
<table class="table center">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
            <!-- Add more columns as per your requirement -->
        </tr>
    </thead>
    <tbody>
        <c:forEach var="citizen" items="${citizens}">
            <tr>
                <td>${citizen.citizen_id}</td>
                <td>${citizen.name}</td>
                <td>${citizen.city}</td>
                <!-- Add more columns as per your requirement -->
            </tr>
        </c:forEach>
    </tbody>
</table> --%>
    
    

</body>
</html>
