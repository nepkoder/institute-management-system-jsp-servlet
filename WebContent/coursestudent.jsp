
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<%--<%@ include file="pageHeader.jsp" %>--%>
<!---for-static-webpage--->
<jsp:include page="pageHeader.jsp">
	<jsp:param name="title" value="IMS"></jsp:param>
</jsp:include><!----used for dynamic webpage---->
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="header.jsp"></jsp:include>

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="container">
					<div class="card card-register mx-auto mt-5">
						<div class="card-body">
							<form
								action="${pageContext.request.contextPath}/admin/relation/add"
								method="post">
								<div class="form-group">
									<label for="exampleInputDuration">Add Student</label> <select
										class="form-control" name="sid">
										<c:forEach items="${studentdata}" var="student">
											<option value="${student.id}">${student.name}</option>
										</c:forEach>

									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputDuration">Add Course</label> <select
										class="form-control" name="cid">
										<c:forEach items="${coursedata}" var="course">
											<option value="${course.id}">${course.title}</option>
										</c:forEach>

									</select>
								</div>

								<input type="submit" class="btn btn-primary btn-block"
									value="Add">
							</form>
						</div>
					</div>
				</div>
			</div>
			<!---row-close---->
		</div>
		<!---container-fluid-close--->

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<!---content-wrapper-close---->
</body>
</html>
