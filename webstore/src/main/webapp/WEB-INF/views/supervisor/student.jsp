<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
 <title>Supervisor Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<a  href="#">See proposal</a>  &emsp; <a href="#">See logs</a> &emsp;
Meeting time : Sunday   1:15PM  &emsp; current status:Upcoming
<div><br>
	<div class="card">
	  <div class="card-header">
	    <div>General Informations</div> 
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
		  Cell Phone: 
		</div>
		<div class="col-2" id="">
		   ${student.cellPhone}
		</div>
        </div>
	  </div>
	  
	</div>	
</div>
<br>
<div class="card">
  <h5 class="card-header">Company and Supervisor Information</h5>
  <div class="card-body">
   <div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Supervisor Information</h5>
         Name : Md. Sohel Rana <br>
         Cell : 015648325 <br>
         Project Manager,Software Development,Square Dots       
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Company Information</h5>
         Name : Square Dots <br>
         Cell : 01875080450 <br>
         76/D DIT road, Malibagh, AM plaza 3rd floor,
         W Malibagh, Dhaka 1217  
        </div>
    </div>
  </div>
</div>
  </div>
</div>
</div>

</body>
</html>
