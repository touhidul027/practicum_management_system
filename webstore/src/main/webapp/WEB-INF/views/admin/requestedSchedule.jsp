<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
 <title>Schedule</title>
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
 
 <div class="container" >
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Supervisor</th>
	  <th scope="col">Request Sent Time</th>
	  <th scope="col">Current Date</th>
	  <th scope="col">New Requested Date</th>
	  <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>15103199</td>
      <td>Md. Touhidul Islam</td>
      <td>Safwana Haque</td>
	  <td>13 December 2019 23:50:49,999</td>
	  <td>23 December 2019 23:50:49,999</td>
	  <td>25 December 2019 23:50:49,999</td>
	  
	  <td>
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Action
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Accept</a>
          <a class="dropdown-item" href="#">Deny</a>
          <a class="dropdown-item" href="#">Compare</a>
        </div>
      
	  </td>
    </tr>
	
	<tr>
      <th scope="row">1</th>
      <td>15103199</td>
      <td>Md. Touhidul Islam</td>
      <td>Safwana Haque</td>
      <td>15 December 2019 23:50:49,999</td>
	  <td>22 December 2019 23:50:49,999</td>
	  <td>28 December 2019 23:50:49,999</td>
	  <td>
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Action
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Accept</a>
          <a class="dropdown-item" href="#">Deny</a>
          <a class="dropdown-item" href="#">Compare</a>
        </div>
      
	  </td>
    </tr>
  </tbody>
</table>
</div>


</hr>
</br>
</br></br></br>
<div class="container" style="border:2px;" >
Managing Schedule
<table class="table">
<tr>
	<th scope="col">
	Serial
	</th>
	<th scope="col">
	ID
	</th>
	<th scope="col">
	Student Name
	</th>
	<th scope="col">
	Supervisor Name
	</th>
</tr>

<tr>
	<td>
	01
	</td>
	<td>
	15103230
	</td>
	<td>
	Mahadi Hasan
	</td>
	<td>
	Alien
	</td>
</tr>

</table>
Manage with the following
<table class="table">
<tr>
	<th scope="col">
	Serial
	</th>
	<th scope="col">
	ID
	</th>
	<th scope="col">
	Student Name
	</th>
	<th scope="col">
	Supervisor Name
	</th>
	<th scope="col">
	Assigned
	</th>
	<th scope="col">
	Time
	</th>
	<th scope="col">
	Replacing ID
	</th>
	<th scope="col">
	Action
	</th>
</tr>

<tr>
	<td>
	01
	</td>
	<td>
	15103230
	</td>
	<td>
	Mahadi Hasan
	</td>
	<td>
	Alien
	</td>
	<td>
	Alien
	</td>
	<td></td>
	<td>
	Alien
	</td>
	<td>
	Alien
	</td>
</tr>

<tr>
	<td>
	01
	</td>
	<td>
	15103230
	</td>
	<td>
	Mahadi Hasan
	</td>
	<td>
	Alien
	</td>
	<td>
	Alien
	</td>
	<td></td>
	<td>
	Alien
	</td>
	<td>
	Alien
	</td>
</tr>
</table>
</div>
 
</body>

</html>
