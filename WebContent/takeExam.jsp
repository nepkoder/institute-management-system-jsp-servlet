
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
				<div class="col-12">
					<h1>Edit course</h1>
				</div>
				<div class="container">
					<div class="card card-register mx-auto mt-5">
						<div class="card-header">Take Exam</div>
						<div class="card-body">
							<form
								action="${pageContext.request.contextPath}/admin/exam/check"
								method="post">
								<div class="form-group">
									<label for="exampleInputId">Question</label> <input
										class="form-control" name="id" id="exampleInputId" type="text"
										value="${qa.get(0).question}" readonly>
								</div>
								<div class="form-group">
									<label for="exampleInputTitle">Choose Answer</label>
									<div class="class="form-control"">
										<inpu name="answer" id="exampleInputTitle" type="text"
											value="${qa.get(0).answer1}"> <inpu name="answer"
											id="exampleInputTitle" type="text"
											value="${qa.get(0).answer2}"> <inpu name="answer"
											id="exampleInputTitle" type="text"
											value="${qa.get(0).answer3}"> <inpu name="answer"
											id="exampleInputTitle" type="text"
											value="${qa.get(0).answer4}">
									</div>
								</div>
								

								<input type="submit" class="btn btn-primary btn-block"
									value="Check Answer">
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
