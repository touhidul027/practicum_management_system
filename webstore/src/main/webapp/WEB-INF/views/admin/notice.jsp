<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
 <title>Dep. Notice</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
  <script type = "text/javascript">
	  function targetAll() {   	 
		   document.getElementById("target").value = "ALL users will get this notice";  	  
	  }
	  function targetSupervisors() {   	 
		   document.getElementById("target").value = "Only All Supervisors will get this notice";  	  
	  }
	  
	  function targetStudents() {   	 
		   document.getElementById("target").value = "Only All students will get this notice ";  	  
	  }
	  
	  function targetSupervisor() {   	 
		   document.getElementById("target").value = "Specific Supervisor will get this notice.Provide ID";  	  
	  }
	  
	  function targetStudent() {   	 
		   document.getElementById("target").value = "Specific Student will get this notice.Give ID";  	  
	  }
	  
	  function targetSupervisorGroups() {   	 
		   document.getElementById("target").value = "Particular supervisor and his students will get this notice.Provide Supervisor ID";  	  
	  }    
  </script>
  
</head>
<body>

<!-- add header part  ? which lib iis used-->
<jsp:include page="header.jsp"></jsp:include>
<br><br>
<div class="container" >
<div class="card" style="width: 40rem;">

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Select</button>
    <div class="dropdown-menu targetClass">
      <a class="dropdown-item" onclick="targetAll();" >All</a>
      <a class="dropdown-item" onclick="targetSupervisors();" >All Supervisors</a>
      <a class="dropdown-item" onclick="targetStudents();" >All Students</a>
      <a class="dropdown-item" onclick="targetSupervisor();">Specific Supervisor</a>
      <a class="dropdown-item" onclick="targetStudent();">Specific Student</a>
      <a class="dropdown-item" onclick="targetSupervisorGroups();" >Supervisor Groups</a>
     </div>
  </div> 
  <input id="target" type="text" class="form-control" aria-label="Text input with dropdown button" value="ALl users will get Notice" >
</div>

</div>

<br>


</div>
<br><br>

<div class="container" >
<div class="card" style="">
<form>
  
  <div class="checkbox">
  <label><input type="checkbox" value=""> Send Notice to Email Also </label>
  </div>
  
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Subject</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Need to be presented at.....">
    </div>
  </div>

  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Description</label>
    <div class="col-sm-10">
		<textarea class="form-control" rows="5" name="message"></textarea>    
	</div>
  </div>
  
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Publish Notice</button>
    </div>
  </div>
  
</form>
</div>
</div>

</body>
</html>
