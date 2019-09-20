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
      <th scope="col">Email</th>
	  <th scope="col">Department</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="count" value="0" scope="page" />
  <c:forEach items="${supervisors}" var="supervisor">
  <c:set var="count" value="${count + 1}" scope="page"/>
    <tr>
      <th scope="row"> <c:out value="${count}" /> </th>
      <td><a class="nav-link"  href="<c:url value="/admin/getSupervisor/${supervisor.supervisorId } " /> " >${supervisor.supervisorId } </a> </td>
      <td>${supervisor.userName}</td>
      <td> ${supervisor.email} </td>
	  <td>${supervisor.department} </td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>
</div>
 
 
</body>

</html>
