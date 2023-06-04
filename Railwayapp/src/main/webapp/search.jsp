<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.servlet.*" %>
    <%@page import="com.railway.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Dashboard</title>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<style>

		body
		{
		background:url('static/img_4.jpg') no-repeat;
		background-size:cover;


		}
nav {
            background-color: grey;
        }
		.brand-logo, #nav-mobile a {
            color: #fff;
        }


	</style>

</head>
<body>
	<nav>
	    <div class="nav-wrapper">
		    <a href="{{url_for('home')}}" class="brand-logo">RAILWAY CROSSING PORTAL</a>
		    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons white-text">menu</i></a>
	      	<ul id="nav-mobile" class="right  hide-on-med-and-down">
	      		
	      		<li>
		        	<a href="" class="nav-item dropdown-trigger profile" data-target='dropdown2'>
		        		<i class="material-icons right white-text" style="font-size: 3rem; margin-left: .5rem;">account_circle</i>
		        		<span style="text-transform: capitalize;">Hi ADMIN</span>
		        	</a>
	      		</li>
	      	</ul>
	    </div>
	</nav>

	<ul class="sidenav" id="mobile-demo">
		<li>
			<div class="user-view">
	            <div class="background">
	            	<img src="{{url_for('static', filename='images/user-bg.jpg')}}">
	            </div>
			  
            </div>
      	</li>
	   
	</ul>

	<ul id="dropdown2" class="dropdown-content">
		
		<li>
			<a href="{{url_for('logout')}}" class="red-text text-lighten-2"><i class="material-icons">logout</i>Logout</a>
		</li>
	</ul>


	<%
	CrossingDAO dao=new CrossingDAO();
	String raddress=request.getParameter("raddress");
	Crossing c=new Crossing();
	c.setRaddress(raddress);
	List<Crossing> results = dao.search(c);
	
	%>
<div id="crossing-list" class="col s12">
	<div class="row">
		<div class="col l8 s10 offset-l2 offset-s1">


<table border=1>
		<tr>
			<th>Railway ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>LandMark</th>
			<th>Schedule</th>
			<th>Person in charge</th>
			<th>Status</th>
			<th></th>
			<th></th>
			

		</tr>
	
			   
			<td>
				<% for (Crossing result : results) { %>
                <tr>
                    <td><%= result.getRid() %></td>
                    <td><%= result.getRname() %></td>
                    <td><%= result.getRaddress() %></td>
                    <td><%= result.getRlandmark() %></td>
                   <td><%= result.getRschedule() %></td>
                   <td><%= result.getRperson() %></td>
                    <td>
            <% if (result.getRstatus().equals("OPEN")) { %>
                <a class="btn green">OPEN</a>
            <% } else if (result.getRstatus().equals("CLOSE")) { %>
                <a class="btn red">CLOSE</a>
            <% } %>
        </td>
                </tr>
            <% } %>
			
								
				
				
			</tr>
	</table>
		</div>
	</div>
</div>
</body>
</html>