<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
 <title>Student Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
</head>
<body>
<div class="container" >
 <div align="center" style="padding:20px;">
  <h3 >School management System : IUBAT</h3>
  Student Page
 </div>
</div>


<div class="container" >
 
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Log Activities
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Submitted Form</a>
          <a class="dropdown-item" href="#">Status</a>
          <a class="dropdown-item" href="#">New Form</a>
        </div>
      </li>
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Software process model
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Waterfall</a>
          <a class="dropdown-item" href="#">SDLC</a>
          <a class="dropdown-item" href="#">Incremental</a>
	      <a class="dropdown-item" href="#">Agile</a>
        </div>
      </li>      
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Message
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">msg</a>
          <a class="dropdown-item" href="#">SDLC</a>
          <a class="dropdown-item" href="#">Incremental</a>
	      <a class="dropdown-item" href="#">Agile</a>
        </div>
      </li>    
	  
	 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Notice
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Group Meeting on sunday.....</a>
          <a class="dropdown-item" href="#">Group Meeting on sunday.....</a>
          <a class="dropdown-item" href="#">Group Meeting on sunday.....</a>
	      <a class="dropdown-item" href="#">Group Meeting on sunday.....</a>
        </div>
      </li>  

	  <li class="nav-item">
          <a  class="nav-link"  href="<c:url value="/logout" />">Logout</a>
      </li>	  
	  
    </ul>
  </div>
</nav>
</div>

</body>
</html>
