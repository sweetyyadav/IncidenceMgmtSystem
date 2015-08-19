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
						<form:form method="post" class="bs-example form-horizontal" modelAttribute="complaintForm">
						<form:hidden path="tenantDetailsId" value="${tenant.tenantDetailsId}"/>
							<fieldset>
								<legend>Complain Form</legend>
								<div class="form-group">
									<label for="userNameInput" class="col-lg-3 control-label">Tenant Name</label>
									<div class="col-lg-9">
										${tenant.tenantName}
									</div>
								</div>
								<div class="form-group">
									<label for="passwordInput" class="col-lg-3 control-label">Apartment Number</label>
									<div class="col-lg-9">
										${tenant.apartmentNo}
									</div>
								</div>
								<div class="form-group">
									<label for="firstNameInput" class="col-lg-3 control-label">Complaint Type</label>
									<div class="col-lg-9">
										<form:select path="complaintTypeId" cssClass="form-control">
										<option value=""> --Select-- </option>
										<c:forEach items="${complaintTypeList}" var="comType">
											<option value="${comType.complaintTypeId}"> ${comType.complaintTypeName} </option>
										</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<label for="lastNameInput" class="col-lg-3 control-label">Complaint Description</label>
									<div class="col-lg-9">
										<form:textarea path="complaintDescription" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="dateOfBirthInput" class="col-lg-3 control-label">Availiability Time</label>
									<div class="col-lg-9">
										<form:select path="DateTime" cssClass="form-control">
											<option>--Select--</option>
											<option value="9:00 AM TO 11:00 AM"> 9:00 AM TO 11:00 AM</option>
											<option value="10:00 AM TO 12:00 AM"> 10:00 AM TO 12:00 AM</option>
											<option value="12:00 AM TO 1:00 PM"> 12:00 AM TO 1:00 PM</option>
											<option value="1:00 AM TO 2:00 PM"> 1:00 AM TO 2:00 PM</option>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label for="emailAddressInput" class="col-lg-3 control-label">Contect Number</label>
									<div class="col-lg-9">
										<form:input path="phoneNo" cssClass="form-control" maxlength="10"/>
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default"><a href="/IncidenceMgmtSystem">Cancel</a></button>
									<input type="submit" value="Save" id="yesbutton" class="btn btn-primary" data-loading-text="Saving.." data-complete-text="Submit Complete!">
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>