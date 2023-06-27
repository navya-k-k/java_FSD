<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Citizens</title>
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
        .btn-view {
            background-color: #337ab7;
        }
        .btn-edit {
            background-color: #5cb85c;
        }
        .btn-delete {
            background-color: #d9534f;
        }
        .btn-add {
            background-color: #337ab7;
            float: right;
            margin-top: -40px;
        }
    </style>
</head>
<body>
     <h1 class="center">Citizens Dashboard</h1>

    <div class="center">
        <a href="/citizens" class="btn">Citizens</a>
        <a href="/vaccinationcentre" class="btn">Vaccination Centers</a>
        <a href="/login" class="btn">Logout</a>
    </div>

    <h2 class="center">Centers</h2>
<a href="/add-citizen" class="btn btn-add">Add new Citizen</a>
    
    <table class="table center">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>City</th>
                <th>Number of Doses</th>
                <th>Vaccination Status</th>
                <th>Vaccination Center</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${citizens}" var="citizen">
                <tr>
                    <td>${citizen.id}</td>
                    <td>${citizen.name}</td>
                    <td>${citizen.city}</td>
                    <td>${citizen.numberOfDoses}</td>
                    <td>${citizen.vaccinationStatus}</td>
                    <td>${citizen.vaccinationCenter}</td>
                    <td>
                        <a href="/view-citizen/${citizen.id}" class="btn btn-view">View</a>
                        <a href="/edit-citizen/${citizen.id}" class="btn btn-edit">Edit</a>
                        <a href="/delete-citizen/${citizen.id}" class="btn btn-delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                 <td colspan="6" style="text-align: right;"><b>Total Citizens Found:</b></td>
                <td>${totalCitizens}</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
