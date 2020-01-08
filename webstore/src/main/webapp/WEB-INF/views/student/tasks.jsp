<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 
<html>
<head>
 <title>Student Tasks</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
  
  <script type = "text/javascript">
       function showNewTaskForm() {
    	  document.getElementById("taskList").style.display = "none";
          document.getElementById("taskForm").style.display = "block"; 
       }
       
       function showAllTasks() {
          document.getElementById("taskForm").style.display = "none"; 
     	  document.getElementById("taskList").style.display = "block";
       }
       
       function createTask() {
    	   alert("New Student will be added.");
    	   document.getElementById("registrationForm").style.display = "none";
    	   $.ajax({
    	        type: "post",
    	        url: "http://localhost:8080/webstore/rest/student/registerStudent",
    	        cache: false,    
    	        data:'studentId=' + $("#studentId").val()+"&studentName="+ $("#studentName").val()+"&studentEmail="+$("#studentEmail").val(),
    	        success: function(student){  
    	        	 console.log(student.studentDepartment);
    	        },
    	        error: function(){      
    	         alert('Error while request..');
    	        }
    	       });
       }
  </script>
</head>
<body>
<!-- add header part  ? which lib iis used-->
<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="container" >
    	<div class="container" >
			<input class="btn btn-link" type="button" value="All Tasks" onclick="showAllTasks();">
			<input class="btn btn-link" type="button" value="New Task" onclick="showNewTaskForm();">		
		</div>
	</div>
	
	<div class="container" id="taskForm" style="display:none;" > 
		<div class="card" style="width: 60rem;">
		<div class="card-header">Register A new Student</div>
		  <div class="card-body">
		    <h5 class="card-title" id="userName" ></h5>
		    <div class="card-subtitle mb-2 text-muted" id="showInfo">
		    </div>
			
			<div class="form-row">
				<div class="col-sm-2" >
				  ID:
				</div>
				<div class="col-sm-3" >
				   <input type="text" id="studentId" class="form-control" name="">
				</div>	
		    </div>
			
			<div class="form-row">
				<div class="col-sm-2" >
				  Name:
				</div>
				<div class="col-sm-3" >
				   <input type="text" id="studentName" class="form-control" name="">
				</div>
		    </div>
		    
		    <div class="form-row">
				<div class="col-sm-2" >
				  Email:
				</div>
				<div class="col-sm-3" >
				   <input type="text" id="studentEmail" class="form-control" name="">
				</div>
		    </div>
			<br>
			
			 <input class="btn btn-primary" type="button" value="Register" onclick="registerStudent();">
		  </div>
		</div>
		</div>
		    
		<div class="container" >
		<div id="taskList" >
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">ID</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
				  <th scope="col">Department</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="count" value="0" scope="page" />
			  <c:forEach items="${students}" var="student">
			  <c:set var="count" value="${count + 1}" scope="page"/>
			   <tr>
			      <th scope="row"><c:out value="${count}" /></th>
			      <td> <a class="nav-link"  href="<c:url value="/admin/getStudent/${student.studentId }" /> " >${student.studentId }</a> </td>
			      <td>${student.userName }</td>
			      <td>${student.studentEmail }</td>
				  <td>${student.studentDepartment }</td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>

</body>
</html>
