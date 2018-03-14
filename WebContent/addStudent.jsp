<%--
  Created by IntelliJ IDEA.
  User: elwyn
  Date: 2/20/2018
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
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
					<h1>Add new Student</h1>
				</div>
				<div class="container">
					<div class="card card-register mx-auto mt-5">
						<div class="card-header">New Student Information</div>
						<div class="card-body">
							<form
								action="${pageContext.request.contextPath}/admin/student/add"
								method="post">
								<div class="form-group">
									<label for="exampleInputTitle">Student Name</label> <input
										class="form-control" name="sname" id="exampleInputTitle"
										type="text" placeholder="Enter student name">
								</div>
								<div class="form-group">
									<label for="inputgender">Gender</label>
									<div class="form-control">
										<input name="sgender" id="inputgender1" value="Male"
											type="radio"> Male &nbsp; <input name="sgender"
											id="inputgender2" value="Female" type="radio">Female
									</div>
								</div>
								<div class="form-group">
									<label for="exampleInputDuration">Country</label> <select
										class="form-control" name="scountry">
										<option value="nepal">Nepal</option>
										<option value="india">India</option>
										<option value="srilanka">Srilanka</option>
										<option value="america">America</option>

									</select>
								</div>
								<div class="form-group">
									<label for="inputhobbies">Hobbies</label>
									<div class="form-control">
										<input name="shobbies" id="exampleInputDuration"
											type="checkbox" value="Sports">Sports &nbsp; <input
											name="shobbies" id="exampleInputDuration" type="checkbox"
											value="Swimming">Swimming &nbsp; <input
											name="shobbies" id="exampleInputDuration" type="checkbox"
											value="dance">Coding &nbsp; <input name="shobbies"
											id="exampleInputDuration" type="checkbox" value="Music">Music
										&nbsp; <input name="shobbies" id="exampleInputDuration"
											type="checkbox" value="Dancing">Dancing &nbsp;
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
