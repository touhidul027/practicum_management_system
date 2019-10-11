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

<script type = "text/javascript">
       function showCommentForm() {
    	    document.getElementById("commentForm").style.display="block";
       }
       function closeCommentForm() {
   	    document.getElementById("commentForm").style.display="none";
       }
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 <c:url var="urlProposalConfirm" value="/project/proposal/supervisor/confirm/${projectProposalDto.studentId}" />
 <c:url var="urlProposalConfirm" value="/project/proposal/supervisor/confirm/${projectProposalDto.studentId}" />

 <div class="container" >
 <div class="col-sm-3 text-center" >
   <a class="nav-link"  href="${urlProposalConfirm}">Accept this proposal</a>
   <a class="nav-link"  onclick="showCommentForm();">Return this proposal</a>
  </div>
 <br>
 <div id="commentForm" class="card" style="display:none;" >
  <c:url var="urlCommentConfirm" value="/project/proposal/supervisor/return/${projectProposalDto.studentId}" />
 <form action="${urlCommentConfirm}" method="post" >
  <div class="form-group col-sm-10">
    <label for="comment">Please put comment</label><br>
    <textarea class="form-control" rows="5" id="comment" name="comment" ></textarea><br>
      <button type="submit" class="btn btn-primary">Submit</button>
   </div>
</form>
   <a class="nav-link"  id="close" onclick="closeCommentForm();" >close</a>
</div>

 </div>
 
 <div class="container text-center">
     <div >
       Development of <br>
      <b>${projectProposalDto.projectTitle}</b> <br>
       for  ${projectProposalDto.projectFor}
    </div>
    <br><br>
	<div>
		By <br>
		${student.userName} <br>
		ID-${projectProposalDto.studentId} <br>
		Department of CSE <br>
		International University of Business Agriculture and technology
	</div>  
	<br><br>
	<b>Development of Practicum Management  System for IUBAT</b>
    <br><br>


	<div class="text-left">
	   <b>Supervisor Details , IUBAT :</b><br>
	   ${supervisor.userName}, <br>
	   ${supervisor.designation},Department of ${supervisor.department},<br>
	   ${supervisor.universityName}<br>
	   Email : ${supervisor.email}<br>
	   Cell Phone : ${supervisor.cellPhone}<br>
	</div>
<br>
  <b>Project Proposal</b>

	<div class="text-left" >
		<b>Organization :</b> ${projectProposalDto.projectDoingAt} <br>
		<b>Project Name :</b> ${projectProposalDto.projectTitle}
	</div>
<br>
	<div class="text-left" >
		<b>Objective:</b><br>
		${projectProposalDto.objective}
	</div>
<br><br>
<div class="text-left" > 
<b>Tools and Technology :</b><br>
The following tools and technology will be used mainly to develop the project<br>

	<div class="row">
		<div class="col-md-4">
			<ol>
				<c:forEach items="${technologicalStacksAsList}" var="technologicalStack">
				 <li>${technologicalStack}</li>
				</c:forEach>
			</ol>
		</div>
	</div>

</div>
<br>
<div class="text-left" > 
<b>Use Case Actors :</b><br>
	<div class="row">
		<div class="col-md-4">
			<ol>
				<c:forEach items="${actorsAsList}" var="actor">
				 <li>${actor}</li>
				</c:forEach>
			</ol>
		</div>
	</div>
</div>
<br>

<div class="text-left" > 
<b>Modules:</b><br>
Requirements of Software are first broken down into several modules that can be incrementally
constructed and delivered.All the modules that have fulfilled the 
functional requirement are given below
	<div class="row">
		<div class="col-md-4">
			<ol>
				<c:forEach items="${modulesAsList}" var="module">
				 <li>${module}</li>
				</c:forEach>
			</ol>
		</div>
	</div>
</div>

<br>
<div class="text-left" > 
<b>Expected Functional Requirement :</b><br>
	<div class="row">
		<div class="col-md-10">
			<ol>
				<c:forEach items="${functionalRequirementsAsList}" var="functionalRequirement">
				 <li>${functionalRequirement}</li>
				</c:forEach>
			</ol>
		</div>
	</div>
</div>

</div>
<br><br><br>
			
			
 
</body>
</html>
