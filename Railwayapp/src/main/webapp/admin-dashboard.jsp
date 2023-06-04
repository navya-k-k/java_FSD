<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.servlet.*" %>
    <%@page import="com.railway.*" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>

	<title>Admin Dashboard</title>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<style>

		body
		{
		background-size:cover;


		}
		nav {
            background-color: grey;
        }
		.brand-logo, #nav-mobile a {
            color: #fff;
        }
        
        

	</style>
	<script>
	
	function confirmDelete(rid) {
	    var result = confirm("Are you sure you want to delete the record with RID: " + rid + "?");
	    if (result) {
	        // User confirmed, navigate to delete.jsp with the rid parameter
	        window.location.href = "delete.jsp?rid=" + rid;
	    } else {
	        // User canceled, do nothing
	    }
	}
	
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
			<a href="logout.jsp" class="red-text text-lighten-2"><i class="material-icons">logout</i>Logout</a>
		</li>
	</ul>




<div class="row" style="margin-bottom: 0;">
	<div class="col l8 s12 offset-l2">
		<div class="row" style="margin-bottom: 0;">
			<div class="col s12" style="margin-top:.1rem;">
				<ul class="tabs">
			        <li class="tab col s4">
			        	<a href="#crossing-list" class="indigo-text text-darken-4">LIST ALL</a>
			        </li>
			        <li class="tab col s4">
			        	<a href="#crossing-add" class="indigo-text text-darken-4">ADD NEW</a>
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
			<th></th>
			<th></th>
			

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
				
			
								<a href="update.jsp?rid=<c:out value="${row.rid}" />" class="btn indigo darken-4 modal-trigger">UPDATE</a>
							</td>
							<td>
							<button onclick="confirmDelete(<c:out value="${row.rid}"/>);" class="btn red">DELETE</button>
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
		<div class="col l0 s5 offset-l2 offset-s1 card-panel grey lighten-2" style="margin-top: 1rem;margin-left:25rem; padding: 1rem;">
			<div class="row">
				<div class="col s12 center">
					<h5 class="indigo-text text-darken-4" style="text-decoration: underline; font-weight: bold;">ADD RAILWAY CROSSING DETAILS</h5>
				</div>
				<form action="addcrossing" method="post">
				<div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rid" type="text" class="validate" name='rid'   required>
				        <label for="rid">Railway Crossing ID</label>
			        </div>
					<div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rname" type="text" class="validate" name='rname'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rname">Railway Crossing Name</label>
			        </div>
			       <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="raddress" type="text" class="validate" name='raddress'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="raddress">Railway Crossing Address</label>
			        </div>
			        <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rlandmark" type="text" class="validate" name='rlandmark'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rlandmark">Railway Crossing Landmark</label>
			        </div>
			       <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rschedule" type="text" class="validate" name='rschedule'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rschedule">Train Schedule</label>
			        </div>
			        <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rperson" type="text" class="validate" name='rperson'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rperson">Person in charge</label>
			        </div>
			      	<div class="col s12 center">
			      		<button type="submit" class="btn indigo darken-4" style="font-weight: bold;">ADD</button>
			      	</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div id="crossing-update" class="modal">
 <div class="row">
		<div class="col l0 s5 offset-l2 offset-s1 card-panel grey lighten-2" style="margin-top: 1rem;margin-left:25rem; padding: 1rem;">
			<div class="row">
				<div class="col s12 center">
					<h5 class="indigo-text text-darken-4" style="text-decoration: underline; font-weight: bold;">ADD RAILWAY CROSSING DETAILS</h5>
				</div>
	
			<form action="updatecrossing" method="post">
			    <div class="modal-content">
			      <h4 class="light-blue-text text-darken-4" style="text-transform: uppercase;">UPDATE DETAILS</h4>
			      	<div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rid" type="text" class="validate" name='rid' value=""  required>
				        <label for="rid">Railway Crossing ID</label>
			        </div>
					<div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rname" type="text" class="validate" name='rname'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rname">Railway Crossing Name</label>
			        </div>
			       <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="raddress" type="text" class="validate" name='raddress'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="raddress">Railway Crossing Address</label>
			        </div>
			        <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rlandmark" type="text" class="validate" name='rlandmark'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rlandmark">Railway Crossing Landmark</label>
			        </div>
			       <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rschedule" type="text" class="validate" name='rschedule'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rschedule">Train Schedule</label>
			        </div>
			        <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rperson" type="text" class="validate" name='rperson'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rperson">Person in charge</label>
			        </div>
			        <div class="input-field col s12">
				        <i class="material-icons prefix">edit</i>
				        <input id="rstatus" type="text" class="validate" name='rstatus'  pattern="[a-zA-Z\s]+"  title="Invalid Railway Crossing Name" required>
				        <label for="rstatus">STATUS</label>
			        </div>
			      	<div class="col s12 center">
			      		<button type="submit" class="btn indigo darken-4" style="font-weight: bold;">ADD</button>
			      	</div>
			</form>
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