<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 
<html>
<head>
 <title>Student Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
</head>
<body>
<!-- add header part  ? which lib iis used-->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<br><br>
<div class="container">
  <a class="btn btn-link"  href="<c:url value="/student/edit/${student.studentId}" /> " ><h4>Edit</h4></a>
<div>

<form:form method="POST" modelAttribute="student"  >
	<div class="card">
	  <div class="card-header">
	    <div>Profile Information</div> 
	  </div>
	  
	  <div class="card-body">
	    <div class="form-row">
		<div class="col-2" >
		  Name : 
		</div>
		<div class="col-2" id="">
		   ${student.userName}
		</div>
        </div>
	  </div>
	  
	  <div class="card-body">
	    <div class="form-row">
		<div class="col-2" >
		  ID : 
		</div>
		<div class="col-2" id="">
		   ${student.studentId}
		</div>
        </div>
	  </div>
	  
	  <div class="card-body">
	    <div class="form-row">
		<div class="col-2" >
		  Email : 
		</div>
		<div class="col-2" id="">
		   ${student.studentEmail}
		</div>
        </div>
	  </div>
	  
	  <div class="card-body">
	    <div class="form-row">
		<div class="col-2" >
		   Department: 
		</div>
		<div class="col-2" id="">
		   ${student.studentDepartment}
		</div>
        </div>
	  </div>
	  
	  <div class="card-body">
	    <div class="form-row">
		<div class="col-2" >
		  Password: 
		</div>
		<div class="col-2" id="">
		   Not Available
		</div>
        </div>
	  </div>
	  
	  <div class="card-body">
	    <div class="form-row">
		<div class="col-2" >
		  Cell: 
		</div>
		<div class="col-2" id="">
		   <input >
		</div>
        </div>
	  </div>
	  
	</div>
</form:form>

</div>
</div>

</body>
</html>
