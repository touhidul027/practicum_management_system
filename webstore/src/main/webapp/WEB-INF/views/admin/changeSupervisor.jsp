<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
 <title> Change Supervisor </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  </style>
  
  <script type="text/javascript">
      function madeAjaxCall(){
       $.ajax({
        type: "post",
        url: "http://localhost:8080/webstore/rest/student",
        cache: false,    
        data:'studentId=' + $("#studentId").val(),
        success: function(response){     
	         document.getElementById("userName").innerHTML = response.userName; 
	         document.getElementById("currentSupervisor").innerHTML = response.supervisor; 
         
	         $.ajax({
	             type: "post",
	             url: "http://localhost:8080/webstore/rest/supervisor/allExcept",
	             cache: false,    
	             data:'supervisorId=9990101' ,
	             success: function(supervisors){
	  
	     	        for(var i = 0; i < supervisors.length; i++) {
	     	           $('#newSupervisors select').append('<option value='+supervisors[i].userName+'>'+supervisors[i].userName+'</option>');
	     	        }
	             },
	             error: function(){      
	              alert('Error while supervisors request..');
	             }
	            });
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
<jsp:include page="header.jsp"></jsp:include>
 <c:url var="getStudent" value="/admin/getAStudent/" />
 <div class="container" >
<form name="employeeForm" method="post" >
  <div class="form-row">
    <div class="col-sm-2">
      Student ID :
    </div>
    <div class="col-3">
      <input type="text" id="studentId" class="form-control" placeholder="ig. 15103199">
    </div>
    <div class="col-2">
     <input type="button" value="Ajax Submit" onclick="madeAjaxCall();"> 
    </div>
  </div>			
</form>

<div class="card" style="width: 60rem;">
  <div class="card-body">
    <h5 class="card-title" id="userName" ></h5>
    <h6 class="card-subtitle mb-2 text-muted">15103199</h6>
	
	<div class="form-row">
		<div class="col-sm-2" >
		  Current Supervisor
		</div>
		<div class="col-3" id="currentSupervisor">
		  
		</div>
    </div>
	
	<div class="form-row">
		<div class="col-sm-2">
		  New Supervisor
		</div>
		<div class="col-3" id="newSupervisors" >
		   <select class="form-control" >
			
		  </select>					
		</div>
    </div>
	<br>
	
    <input id="submit" name="submit" type="submit" value="Done" class="btn btn-primary">
	 
  </div>
</div>
</div>

</body>

</html>
