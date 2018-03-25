
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="">Course</a></li>
				<li class="breadcrumb-item active">Add</li>
			</ol>
			<div class="row">

				<div class="container">
					<div class="card card-register mx-auto mt-5">
						<div class="card-body">
						
						
						<h2>${requestScope.message}</h2>
						<h3>${requestScope.location}</h3>
						
						
						
						
						
						
						
						
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
