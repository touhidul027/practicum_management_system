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
		   document.getElementById("recipent").style.display="";
		   document.getElementById("toId").value = "All";
	  }
	  function targetSupervisors() {   	 
		   document.getElementById("target").value = "Only All Supervisors will get this notice";  	  
		   document.getElementById("recipent").style.display="";
		   document.getElementById("toId").value = "Supervisors";
	  }
	  
	  function targetStudents() {   	 
		   document.getElementById("target").value = "Only All students will get this notice ";  	  
		   document.getElementById("recipent").style.display="";
		   document.getElementById("toId").value = "Students";
	  }
	  
	  function targetSupervisor() {   	 
		   document.getElementById("target").value = "Specific Supervisor will get this notice.Provide ID";  	  
		   document.getElementById("recipent").style.display="";
		   document.getElementById("toId").value = "";
	  }
	  
	  function targetStudent() {
		   document.getElementById("target").value = "Specific Student will get this notice.Give ID";  	  
		   document.getElementById("recipent").style.display="";
		   document.getElementById("toId").value = "";
	  }
	  
	  function targetSupervisorGroups() {
		   document.getElementById("target").value = "Particular supervisor and his students will get this notice.Provide Supervisor ID";  	  
		   document.getElementById("recipent").style.display="";
		   document.getElementById("toId").value = "";
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
      <a class="dropdown-item" onclick="targetSupervisorGroups();" >Supervisor and Groups</a>
     </div>
  </div> 
  <input id="target" type="text" class="form-control" aria-label="Text input with dropdown button" value="Select Option Specifically" >
</div>

</div>
<br>

</div>
<br><br>

<div class="container" >
<div class="card" style="">
<c:url var="url" value="/admin/notice" />

<br>

  <c:url var="url" value="/admin/notice" />

      <form:form method="POST"
          action="${url}" modelAttribute="noticeDTO">
             <table>
                <tr>
                    <td><form:label path="from">From</form:label></td>
                    <td><form:input path="from" readonly="true" /></td>
                </tr>
             
                <tr id="recipent" style="display:none;" >
                    <td><form:label  path="toId">Recipent ID</form:label></td>
                    <td><form:input path="toId" id="toId" /></td>
                </tr>
                
                <tr>
                    <td><form:label path="subject">Subject</form:label></td>
                    <td><form:input path="subject"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:textarea path="description" rows="5" cols="30"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Publish"/></td>
                </tr>
            </table>
        </form:form>
        

</div>
</div>

</body>
</html>
