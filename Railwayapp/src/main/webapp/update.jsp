<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.servlet.*" %>
    <%@page import="com.railway.*" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
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

 <div class="row">
		<div class="col l0 s5 offset-l2 offset-s1 card-panel grey lighten-2" style="margin-top: 1rem;margin-left:25rem; padding: 1rem;">
			<div class="row">				
	
	<%
	CrossingDAO dao=new CrossingDAO();
	int rid=Integer.parseInt(request.getParameter("rid"));
	Crossing c=new Crossing();
	c.setRid(rid);
	Crossing result=dao.select(c);
	

	%>
			<form action="update" method="POST">
			      <h4 class="light-blue-text text-darken-4 center" style="text-transform: uppercase;">UPDATE DETAILS</h4>
			      	<div class="input-field col s12">
				 Railway Crossing ID
				        
				        <input id="rid" type="text" class="validate" name='rid' value="<%= result.getRid() %>"  required>
			        </div>
					<div class="input-field col s12">
				 Railway Crossing Name
				        
				        <input id="rname" type="text" class="validate" name='rname' value="<%= result.getRname() %>"  required>
			        </div>
			      <div class="input-field col s12">
				 Railway Crossing Address
				        
				        <input id="raddress" type="text" class="validate" name='raddress' value="<%= result.getRaddress() %>"  required>
			        </div>
			        <div class="input-field col s12">
				 Railway Crossing LandMark
				        
				        <input id="rlandmark" type="text" class="validate" name='rlandmark' value="<%= result.getRlandmark() %>"  required>
			        </div>
			       <div class="input-field col s12">
				Schedule				        
				        <input id="rschedule" type="text" class="validate" name='rschedule' value="<%= result.getRschedule() %>"  required>
			        </div>
			       <div class="input-field col s12">
				 Person in charge
				        
				        <input id="rperson" type="text" class="validate" name='rperson' value="<%= result.getRperson() %>"  required>
			        </div>
			        <div class="input-field col s12">
				 status
				        
				        <input id="rstatus" type="text" class="validate" name='rstatus' value="<%= result.getRstatus() %>"  required>
			        </div>
			      	<div class="col s12 center">
			      		<button type="submit" class="btn indigo darken-4" style="font-weight: bold;">UPDATE</button>
			      	</div>
			</form>
		</div>
</body>
</html>