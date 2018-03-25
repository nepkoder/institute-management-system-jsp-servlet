
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
						<form action="${pageContext.request.contextPath}/admin/fileupload"
							method="POSt" enctype="multipart/form-data">
							<div class="form-group">
								<label>Username:</label> <input class="form-control" type="text"
									name="username" size="60">
							</div>
							<div class="form-group">
								<label>User role:</label> <select class="form-control"
									name="userrole">
									<option value="admin">Administration</option>
									<option value="user">Registered User</option>
									<option value="anynomous">General User</option>
								</select>
							</div>
							<div class="form-group">
								<p>Select Image file to upload:</p>
								<input class="form-control" type="file" name="file" size="60">
							</div>
							<br> <input class="btn btn-outline-primary" type="submit"
								value="Upload File">
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!---container-fluid-close--->


	<jsp:include page="footer.jsp"></jsp:include>
	<!---content-wrapper-close---->
</body>
</html>
