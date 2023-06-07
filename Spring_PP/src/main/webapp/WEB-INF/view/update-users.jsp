<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
<center>
    <h4>USER DETAILS</h4>
    
    <form action="updateUsers" method="POST" modelAttribute="user">
    
            <label>User ID:</label>
        <input type="text" name="user_id" value="${listOfUsers.user_id}" readonly=""><br><br>
                <label>User Name:</label>
        
       <input type="text" name="uname" value="${listOfUsers.uname}"><br><br>
               <label>User Age:</label>
       
         <input type="text" name="age" value="${listOfUsers.age}"><br><br>
                
         
         
        <input type="submit" value="UPDATE">
    </form>
    </center>
</body>
</html>
