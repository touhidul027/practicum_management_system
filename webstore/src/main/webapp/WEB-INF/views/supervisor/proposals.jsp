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
 
            <div class="card text-center">
			    <div class="card-header">
			    </div>
			    <div class="card-body">
					 <h5 class="card-title">Project Proposals</h5>
					 <p class="card-text"> ${message}</p>
				</div>
				<div class="card-footer text-muted">
				 <c:set var="reviewProposalUrl" value="/webstore/project/proposal/supervisor/review" />
				 <div style="text-align:right;">
		         <a  class="nav-link"  href="${reviewProposalUrl}"> Review </a>
		        </div>				   
			    </div>
			</div>
			
			
 
</body>
</html>
