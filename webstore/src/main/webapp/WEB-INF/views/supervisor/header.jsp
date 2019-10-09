<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container" >
 <div align="center" style="padding:20px;">
  <h3 >Practicum management System : IUBAT</h3>
  You are a SUPERVISOR
 </div>
</div>

<c:set var="urlViewProposals" value="/webstore/supervisor/proposals/" />


<div class="container" >
 
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
	
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Student List
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Touhidul Islam</a>
          <a class="dropdown-item" href="#">Anik khan </a>
          <a class="dropdown-item" href="#">Mahadi Hasan</a>
        </div>
      </li>
	  <li class="nav-item">
<c:set var="proposals" value="/webstore/supervisor/proposals" />
        <a class="nav-link" href="${proposals}">Proposals</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Put Notice</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Send Mail</a>
      </li>
	  
	  <li class="nav-item">
        <a class="nav-link" href="#">Chat</a>
      </li>
	  
	  <li class="nav-item">
        		<a  class="nav-link"  href="<c:url value="/logout" />">Logout</a>
       </li>
       
    </ul>
  </div>
</nav>
</div>

<br><br>
