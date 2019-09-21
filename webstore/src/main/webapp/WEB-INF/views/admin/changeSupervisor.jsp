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
        url: "http://localhost:8080/webstore/rest/admin/changeSupervisor/getInfo",
        cache: false,    
        data:'studentId=' + $("#studentId").val(),
        success: function(changeSupervisorDTO){  
        	 $('#newSupervisors select').find('option').remove();    	
	         document.getElementById("userName").innerHTML = changeSupervisorDTO.studentName; 
	         document.getElementById("showInfo").innerHTML = $("#studentId").val();
	         document.getElementById("currentSupervisor").innerHTML = changeSupervisorDTO.supervisorUserName;          
	         var supervisors = changeSupervisorDTO.supervisors ;
	        
	            Object.keys(supervisors).forEach(function(key) {
		     	      $('#newSupervisors select').append('<option value='+key+'>'+supervisors[key]+'</option>');
	            });	           
        },
        error: function(){      
         alert('Error while request..');
        }
       });
      }
      
      function changeSupervisor(){
    	  alert("You are about to change supervisor");
    	  var select = document.getElementById("s");
    	  var newSupervisorId = select.options[select.selectedIndex].value;
    	  var newSupervisorName = select.options[select.selectedIndex].text;

          $.ajax({
              type: "post",
              url: "http://localhost:8080/webstore/rest/admin/changeSupervisor/change",
              cache: false, 
              data:'studentId=' + $("#studentId").val()+"&supervisorId="+newSupervisorId,
              success: function(changeSupervisorDTO){       	                    	  
                  $('#resultedStudentName').empty().append(changeSupervisorDTO.studentName);
                  $('#resultedStudentId').empty().append(changeSupervisorDTO.studentId);
                  $('#resultedSupervisorName').empty().append(changeSupervisorDTO.supervisorUserName);
                  $('#resultedSupervisorEmail').empty().append("No info");
              },
              error: function(){      
               alert('Error while request..');
               console.log(newSupervisorId);
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
    <div class="card-subtitle mb-2 text-muted" id="showInfo">
    </div>
	
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
		   <select class="form-control" id="s" >
			
		  </select>					
		</div>
    </div>
	<br>
	
	 <input class="btn btn-primary" type="button" value="Change" onclick="changeSupervisor();">
  </div>
</div>
<br><br>

<div class="card changeSupervisorResultForm" style="width: 60rem;">
  <div class="card-body">

    <div class="card-subtitle mb-2 " id="">
     <h5>New Supervisor Information</h5>
    </div>
	
	<div class="form-row">
		<div class="col-sm-2" >
		  Student Name : 
		</div>
		<div class="col-3" id="resultedStudentName">
		 
		</div>
    </div>
    <div class="form-row">
		<div class="col-sm-2" >
		  Student ID : 
		</div>
		<div class="col-3" id="resultedStudentId">
		 
		</div>
    </div>
    <div class="form-row">
		<div class="col-sm-2" >
		  Supervisor Name : 
		</div>
		<div class="col-3" id="resultedSupervisorName">
		  
		</div>
    </div>
	
	<div class="form-row">
		<div class="col-sm-2" >
		  Supervisor Email : 
		</div>
		<div class="col-3" id="resultedSupervisorEmail">
		  
		</div>
    </div>
    
  </div>
</div>

</div>

<script> 

</script>

</body>

</html>
