<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1 class="center">Registration</h1>
    <form action="/registration" method="POST" class="center">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
