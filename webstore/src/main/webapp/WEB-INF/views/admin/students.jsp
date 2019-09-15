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
      <th scope="col">Supervisor</th>
	  <th scope="col">Change</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${students}" var="student">
   <tr>
      <th scope="row">1</th>
      <td> <a class="nav-link"  href="<c:url value="/admin/getStudent/${student.id }" /> " >${student.id }</a> </td>
      <td>${student.userName }</td>
      <td>${student.supervisor }</td>
	  <td>${student.userName }</td>
    </tr>
  </c:forEach>
	 <tr>
      <th scope="row">1</th>
      <td> 100*</td>
      <td> Sample Name</td>
      <td> Sample supervisor</td>
	  <td> Sample Confirmation </td>
    </tr>
  </tbody>
</table>
</div>


</body>
</html>
