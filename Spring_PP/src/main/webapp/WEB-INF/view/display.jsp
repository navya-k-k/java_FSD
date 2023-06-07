<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Updated User Details</title>
</head>
<body>
    
    <table align="center">
       <caption><h3>Updated User Details</h3></caption> 
    
        <tr>
            <th>User ID:</th>       
            <td>${updatedUser.user_id}</td>
        </tr>
         <tr>
            <th>User Name:</th>       
            <td>${updatedUser.uname}</td>
        </tr>
         <tr>
            <th>Age:</th>       
            <td>${updatedUser.age}</td>
        </tr>
         
              
           
    </table>
</body>
</html>
