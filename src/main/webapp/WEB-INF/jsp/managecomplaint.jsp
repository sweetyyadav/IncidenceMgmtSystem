<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Complaint</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="datepicker/css/datepicker.css" rel="stylesheet" />
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
<style>
.green {
	font-weight: bold;
	color: green;
}
.message {
	margin-bottom: 10px;
}
.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<div class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/IncidenceMgmtSystem">Home</a></li>
				<li class="active"><a href="signup.html">Signup</a></li>
				<li><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<script src="jquery-1.8.3.js">
	</script>
	<script src="bootstrap/js/bootstrap.js">
	</script>
	<script src="datepicker/js/bootstrap-datepicker.js">
	</script>
	
	 <c:if test="${not empty param.message}">
		<div class="message green">${param.message}</div>
	</c:if> 
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<table width="100%">
						 <thead>
						 	<tr>
						 		<th width="10%">S No.</th>
						 		<th width="20%">Complaint Type</th>
						 		<th width="40%">Complaint Description</th>
						 		<th width="20%">Availiability Time</th>
						 		<th width="10%">Action</th>
						 	</tr>
						 </thead>
						
						<c:forEach items="${COMPLAINT_LIST}" var="complain" varStatus="count">
							<tr>
								<td>${count.count}</td>
								<td>${complain.complaintType.complaintTypeName}</td>
								<td>${complain.complaintDescription}</td>
								<td>${complain.avialabilityTime}</td>
								<td><a href="updatecomplaint.html?id=${complain.complaintId}">Update</a></td>
							</tr>
						</c:forEach>	
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>