<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
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
<!-- add header part  ? which lib iis used-->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<br><br>
<div class="container">
     * field are not editable
     <form:form method="POST"
          action="" modelAttribute="student">
             <table>
                <tr>
                    <td><form:label path="userName">Name*</form:label></td>
                    <td><form:input path="userName" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="studentId">Id*</form:label></td>
                    <td><form:input path="studentId" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="studentEmail">Student Email*</form:label></td>                  
                    <td><form:input path="studentEmail" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="studentDepartment">Student Department*</form:label></td>                  
                    <td> <form:input path="studentDepartment" readonly="true"/> </td>
                </tr>
            
                
                <tr>
                    <td><form:label path="cellPhone">Cell Phone</form:label></td>                  
                    <td><form:input path="cellPhone"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="password">Password</form:label></td>                  
                    <td><form:input path="password"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</div>

</body>
</html>
