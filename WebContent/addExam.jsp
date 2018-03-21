
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
					<h1>Add new Question</h1>
				</div>
				<div class="container">
					<div class="card card-register mx-auto mt-5">
						<div class="card-body">
							<form
								action="${pageContext.request.contextPath}/admin/exam/add"
								method="post">
								<div class="form-group">
									<label for="exampleInputTitle">Question</label> <input
										class="form-control" name="question" id="exampleInputTitle"
										type="text" placeholder="Enter question">
								</div>
							
								<div class="form-group">
									<label for="inputanswer">Answer</label>
									<div class="form-control">
										<input name="ans1" class="form-control" id="exampleInputDuration"
											type="name" value="" placeholder="1. Answer">&nbsp;
											<input
											name="ans2" class="form-control" id="exampleInputDuration" type="name"
											value="" placeholder="2. Answer"> &nbsp;
											<input
											name="ans3" class="form-control" id="exampleInputDuration" type="name"
											value="" placeholder="3. Answer" > &nbsp;
											<input name="ans4" class="form-control"
											id="exampleInputDuration" type="name" placeholder="4. Answer" value="">
										&nbsp; <input name="right" class="form-control" id="exampleInputDuration"
											type="name" value="" placeholder="Right Answer"> &nbsp;
									</div>
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
