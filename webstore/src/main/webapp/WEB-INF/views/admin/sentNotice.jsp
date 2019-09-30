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
</head>
<body>

<!-- add header part  ? which lib iis used-->
<jsp:include page="header.jsp"></jsp:include>
<br><br>

<c:url var="urlSent" value="/notice/get/all" />

<div class="container" id="" > 
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">        
      <li class="nav-item active">
        <a class="nav-link" href="#">Inbox <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link active" href="">Sent <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Compose <span class="sr-only">(current)</span></a>
      </li>     
    </ul>
  </div>
</nav>
</div>
<br>



<div class="container" >
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">To</th>
      <th scope="col">Subject</th>
      <th scope="col">Time</th>
    </tr>
  </thead>
  <tbody id="tableBody" >
  <c:set var="count" value="0" scope="page" />
  <c:forEach items="${noticeDTOsMap}" var="noticeDTOMap">
  <c:set var="count" value="${count + 1}" scope="page"/>
   <c:set var="noticeDTO" scope = "session" value = "${noticeDTOMap.value}" />
   <tr>
      <th scope="row"><c:out value="${count}" /></th>
      <td>${noticeDTO.toId}</td>
      <td>${noticeDTO.subject}</td>
	  <td>${noticeDTOMap.key}</td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>
