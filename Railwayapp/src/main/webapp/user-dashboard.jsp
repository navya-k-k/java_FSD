<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.servlet.*" %>
    <%@page import="com.railway.*" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>User Dashboard</title>
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
		
		
		.favorite-btn {
  color: blue; /* Default color */
}

.favorite-btn.favorite {
  color: yellow; /* Color when the button is favorited */
}

	</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(document).ready(function() {
    $(".favorite-btn").click(function() {
      $(this).toggleClass("favorite"); // Toggle the 'favorite' class on click
    });
  });
</script>
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
		        		<span style="text-transform: capitalize;">Hi user</span>
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
			<a href="user-logout.jsp" class="red-text text-lighten-2"><i class="material-icons">logout</i>Logout</a>
		</li>
	</ul>




<div class="row" style="margin-bottom: 0;">
	<div class="col l8 s12 offset-l2">
		<div class="row" style="margin-bottom: 0;">
			<div class="col s12" style="margin-top:.1rem;">
				<ul class="tabs">
			        <li class="tab col s4">
			        	<a href="#crossing-list" class="indigo-text text-darken-4">LIST ALL CROSSING</a>
			        </li>
			        <li class="tab col s4">
			        	<a href="#crossing-add" class="indigo-text text-darken-4">FAVORITE CROSSING</a>
			        </li>
			        <li class="tab col s4">
			        	<a href="#crossing-search" class="indigo-text text-darken-4">SEARCH</a>
			        </li>
			    </ul>
			</div>
		</div>
	</div>
</div>


	
<div id="crossing-list" class="col s12">
	<div class="row">
		<div class="col l8 s10 offset-l2 offset-s1">
			
<sql:setDataSource var="ecommerce" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/railway" user="root" password="rootpassword9" />
		
<sql:query dataSource="${ecommerce}" sql="SELECT * FROM crossing" var="result" />

<table border=1>
		<tr>
			<th>Railway ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>LandMark</th>
			<th>Schedule</th>
			<th>Person in charge</th>
			<th>Status</th>
			
			

		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.rid}" /></td>
				<td><c:out value="${row.rname}" /></td>
				<td><c:out value="${row.raddress}" /></td>
				<td><c:out value="${row.rlandmark}" /></td>
				<td><c:out value="${row.rschedule}" /></td>
				<td><c:out value="${row.rperson}" /></td>
				 <td> <c:if test="${row.rstatus == 'OPEN'}"><a class="btn green"></c:if>
				 <c:if test="${row.rstatus == 'CLOSE'}"><a class="btn red"></c:if>
                        <c:out value="${row.rstatus}" />
                    </td>
                    
		<td>
								<a href="favorite.jsp?rid=<c:out value="${row.rid}"/>" class="favorite-btn">&#9734;</a>
							</td>
			   
			   
			
				
				
			</tr>
		</c:forEach>
	</table>
		</div>
	</div>
</div>

<div id="crossing-search" class="col s8">
	<div class="row">
	<div class="col l0 s5 offset-l2 offset-s1 card-panel grey lighten-2" style="margin-top: 1rem;margin-left:25rem; padding: 1rem;">
			<div class="row">
				
				<form action="search.jsp" method="post">
				<div class="input-field col s8">
				        <i class="material-icons prefix">edit</i>
				        <input id="raddress" type="text" class="validate" name='raddress'  placeholder="search by location" required>
			      		<button type="submit" class="btn indigo darken-4" style="font-weight: bold;">SEARCH</button>
			      	</div>
				</form>
			</div>
		</div>
	</div>
	</div>


<div id="crossing-add" class="col s8">
	<div class="row">
			<div class="col l8 s10 offset-l2 offset-s1">
	
					
<sql:setDataSource var="ecommerce" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/railway" user="root" password="rootpassword9" />
		
<sql:query dataSource="${ecommerce}" sql="SELECT * FROM favorite" var="result" />

<table border=1>
		<tr>
			<th>Railway ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>LandMark</th>
			<th>Schedule</th>
			<th>Person in charge</th>
			<th>Status</th>
			
			

		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.rid}" /></td>
				<td><c:out value="${row.rname}" /></td>
				<td><c:out value="${row.raddress}" /></td>
				<td><c:out value="${row.rlandmark}" /></td>
				<td><c:out value="${row.rschedule}" /></td>
				<td><c:out value="${row.rperson}" /></td>
				 <td> <c:if test="${row.rstatus == 'OPEN'}"><a class="btn green"></c:if>
				 <c:if test="${row.rstatus == 'CLOSE'}"><a class="btn red"></c:if>
                        <c:out value="${row.rstatus}" />
                    </td>
                    
		<td>
								<a href="favorite.jsp?rid=<c:out value="${row.rid}"/>" class="favorite-btn1">&#9734;</a>
							</td>
			   
			   
			
				
				
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.sidenav');
	    var instances = M.Sidenav.init(elems);
	  });
	</script>
	<script type="text/javascript">
		 	document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.product');
		    var options={coverTrigger:false,constrainWidth:false}
		    var instances = M.Dropdown.init(elems,options);
		  });
	</script>
	<script type="text/javascript">
		 	document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.profile');
		    var options={coverTrigger:false}
		    var instances = M.Dropdown.init(elems,options);
		  });
	</script>
	 <script type="text/javascript">
	  	 document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.collapsible');
	    var instances = M.Collapsible.init(elems);
	  });

	  </script>

	  <script type="text/javascript">
	  	document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('select');
	    var instances = M.FormSelect.init(elems);
	  });
	  </script>

	  	<script type="text/javascript">
	      	var el = document.querySelector('.tabs');
	      	var instance = M.Tabs.init(el);
	    </script>

	    <script type="text/javascript">
		  	document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.slider');
		    var instances = M.Slider.init(elems);
		  });
		</script>
		<script type="text/javascript">
		  	document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.modal');
		    var instances = M.Modal.init(elems);
		  });
		</script>

		<script type="text/javascript">
	    	document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.dp-reg');
		    var options = {yearRange:[1950,2023], format:"dd/mm/yyyy"}
		    var instances = M.Datepicker.init(elems, options);
		  });
	    </script>
</body>
</html>