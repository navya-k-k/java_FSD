<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Citizen Details</title>
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
    <h1 class="center">Citizen Details</h1>
    <div class="center">
        <a href="/citizens" class="btn">Citizens</a>
        <a href="/vaccinationcentre" class="btn">Vaccination Centers</a>
        <a href="/login" class="btn">Logout</a>
    </div>
    <h2 class="center">Citizen Information</h2>
    <table class="table center">
        <thead>
            <tr>
                <th>${citizen.name}</th>
            </tr>
        </thead>
        <tbody>
            
            <tr>
                <td>ID: ${citizen.id}</td>
            </tr>
            <tr>
                <td>City: ${citizen.city}</td>
            </tr>
            <tr>
                <td>Number of Doses taken: ${citizen.numberOfDoses}</td>
            </tr>
            <tr>
                <td>Vaccination Status: ${citizen.vaccinationStatus}</td>
            </tr>
            <tr>
                <td>Allocated Center: <a href="/vaccinationcentre">${citizen.vaccinationCenter}</a></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
