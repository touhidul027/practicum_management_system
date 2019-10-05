<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 
<html>
<head>
 <title>Project Proposal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<br><br>

<div class="container">
	<div class="card">
		  <div class="card-header">
		    <div>Project Proposal</div> 
		  </div>
		  <c:set var="saveProposalUrl" value="/webstore/project/proposal/save" />
	
		  <div class="card-body">
		   <form:form method="POST" action="${saveProposalUrl}" modelAttribute="projectProposal">
		     <div class="form-row">
				<div class="col-sm-2" path="projectTitle" >
				  Title:
				</div>
				<div class="col-sm-4" >
				   <form:input type="text" path="projectTitle" class="form-control" />
				</div>	
		    </div>
	
			<div class="form-row">
				<div class="col-sm-2" path="projectFor" >
				  Project For:
				</div>
				<div class="col-sm-4" >
				   <form:input type="text" path="projectFor" class="form-control" />
				</div>
		    </div>
    
		    <div class="form-row">
				<div class="col-sm-2" path="projectDoingAt">
				  Project Doing At:
				</div>
				<div class="col-sm-4" >
				   <form:input type="text" path="projectDoingAt" class="form-control" />
				</div>
		    </div>	
		    		
           <div class="form-row">
				<div class="col-sm-2" path="technologicalStacks">
				  Tools/Technological Stack:
				</div>
				 <div class="col-sm-4" >
				   <form:textarea type="text" path="technologicalStacks" class="form-control" rows="5" cols="30"/>
				</div>				
		    </div>	
		    
            <div class="form-row">
				<div class="col-sm-2" path="actors">
				  Actors:
				</div>
				 <div class="col-sm-4" >
				   <form:textarea type="text" path="actors" class="form-control" rows="3" cols="30"/>
				</div>				
		    </div>	
		    
            <div class="form-row">
				<div class="col-sm-2" path="modules">
				  Modules:
				</div>
				 <div class="col-sm-4" >
				   <form:textarea type="text" path="modules" class="form-control" rows="4" cols="30"/>
				</div>				
		    </div>

		    <div class="form-row">
				<div class="col-sm-2" path="functionalRequirements">
				 Functional Requirements:
				</div>
				 <div class="col-sm-4" >
				   <form:textarea type="text" path="functionalRequirements" class="form-control" rows="5" cols="30"/>
				</div>				
		    </div>	
		    <br><br>
		    <tr>
                <td><input type="submit" value="Save"/></td>
            </tr>
             
		     </form:form>     
		</div>
	</div>
</div>


</body>
</html>
