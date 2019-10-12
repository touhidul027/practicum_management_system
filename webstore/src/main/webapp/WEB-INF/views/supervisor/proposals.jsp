<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Supervisor Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">



		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Title</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${projectProposalsDto}" var="projectProposalDto">
					<c:set var="count" value="${count + 1}" scope="page" />
					<c:if test="${projectProposalDto.isSubmitted()}">
						<tr>
							<th scope="row"><c:out value="${count}" /></th>
							<td><a class="nav-link" href="#">${projectProposalDto.studentId}</a>
							</td>
							<td>${studentsMap[projectProposalDto.studentId]}</td>
							<td>${projectProposalDto.projectTitle}</td>
							<td><c:url var="urlProposalReview"
									value="/project/proposal/supervisor/review/${projectProposalDto.studentId}" />
								<c:choose>
									<c:when test="${projectProposalDto.isConfirmed()}">
										<a class="nav-link" href="${urlProposalReview}">Yes
											Confirmed</a>
									</c:when>
									<c:otherwise>
										<a class="nav-link" href="${urlProposalReview}">Please
											Review</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>


	</div>

</body>
</html>
