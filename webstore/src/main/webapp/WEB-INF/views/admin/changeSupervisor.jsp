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
</head>

<body>
<!-- add header part  ? which lib iis used-->
<jsp:include page="header.jsp"></jsp:include>
 <c:url var="getStudent" value="/admin/getAStudent/" />
 <div class="container" >
<form method="GET" >
  <div class="form-row">
    <div class="col-sm-2">
      Student ID :
    </div>
    <div class="col-3">
      <input type="text" class="form-control" placeholder="ig. 15103199">
    </div>
    <div class="col-2">
        <input id="submit" name="submit" type="submit" value="Search" class="btn btn-primary">
     </div>
  </div>			
</form>

<div class="card" style="width: 60rem;">
  <div class="card-body">
    <h5 class="card-title"> Md. Touhidul Islam </h5>
    <h6 class="card-subtitle mb-2 text-muted">15103199</h6>
	
	<div class="form-row">
		<div class="col-sm-2">
		  Current Supervisor
		</div>
		<div class="col-3">
		  Safwana haque
		</div>
    </div>
	
	<div class="form-row">
		<div class="col-sm-2">
		  New Supervisor
		</div>
		<div class="col-3">
		   <select class="form-control" id="Dress">
			<option>Anonymous</option>
			<option>Safwana</option>
			<option>Shaheen</option>
			<option>Rana</option>
			<option>Choyon</option>
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
