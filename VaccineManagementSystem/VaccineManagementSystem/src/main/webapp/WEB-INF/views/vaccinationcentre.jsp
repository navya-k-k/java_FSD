<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        body {
            font-family: "Arial", sans-serif;
            background-color: #e6e6e6;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 960px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 20px;
            padding-top: 0;
            font-size: 28px;
            margin-bottom: 30px;
        }

        .btn-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            background-color: #333;
            border-radius: 4px;
            margin-left: 10px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #555;
        }

        .btn.btn-add {
            background-color: #5cb85c;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .table th,
        .table td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        .table th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        .table td a {
            display: inline-block;
            padding: 6px 12px;
            text-decoration: none;
            color: #fff;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .table td a.btn-view {
            background-color: #337ab7;
        }

        .table td a.btn-edit {
            background-color: #5cb85c;
        }

        .table td a.btn-delete {
            background-color: #d9534f;
        }

        .total-centers {
            text-align: right;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Dashboard</h1>

        <div class="btn-container">
            <a href="/citizens" class="btn">Citizens</a>
            <a href="/vaccinationcentre" class="btn">Vaccination Centers</a>
            <a href="/login" class="btn" style="background-color: #d9534f;">Logout</a>
        </div>

        <a href="/add-centre" class="btn btn-add">Add New Center</a>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${vaccinecentre}" var="centre">
                    <tr>
                        <td>${centre.id}</td>
                        <td>${centre.name}</td>
                        <td>${centre.city}</td>
                        <td>
                            <a href="//view-centre/${centre.id}" class="btn btn-view">View</a>
                            <a href="/edit-centre/${centre.id}" class="btn btn-edit">Edit</a>
                            <a href="/delete-centre/${centre.id}" class="btn btn-delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4" class="total-centers">Total Centers Available:</td>
                    <td>${vaccinecentre.size()}</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
