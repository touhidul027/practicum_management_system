<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container" >
 <div align="center" style="padding:20px;">
  <h3 >School management System : IUBAT</h3>
  Dept. Administator Page - header  Page
 </div>
</div>


<div class="container" >
 
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
	
       <li class="nav-item">
        <a class="nav-link"  href="<c:url value="/admin/students" /> " >Students</a>
      </li>
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Assign Supervisor
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Randomly</a>
          <a class="dropdown-item" href="#">Iteratively</a>
          <a class="dropdown-item" href="<c:url value="/admin/asignSupervisorManually" /> " >Manually</a>
        </div>
      </li>
	  
      <li class="nav-item">
        <a class="nav-link"  href="<c:url value="/admin/supervisors"/>">Supervisors </a>
      </li>
	  
      <li class="nav-item">
        <a class="nav-link"  href="<c:url value="/admin/studentPerformance"/>" >Student Performance</a>
      </li>
	  
	  <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/changeSupervisor"/> " >Change Supervisor</a>
      </li>
	  
	  <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/notice" /> ">Notices</a>
      </li>
      
	  <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/message" /> " >Message</a>
        
      </li>
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Schedule Presentation
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="<c:url value="/admin/requestedSchedule" /> ">Requested Schedule</a>
          <a class="dropdown-item" href="#">Randomly</a>
          <a class="dropdown-item" href="" >Manually</a>
        </div>
      </li>
	  
	 <li class="nav-item">
        <a class="nav-link"   href="<c:url value="/admin/setting" /> "  >Setting</a>
      </li>
      
        <li class="nav-item">
        		<a  class="nav-link"  href="<c:url value="/logout" />">Logout</a>
      </li>
    </ul>
  </div>
</nav>
</div>
