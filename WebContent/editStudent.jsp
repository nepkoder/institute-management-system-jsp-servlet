
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
						<div class="card-header">Edit Course Information</div>
						<div class="card-body">
							<form
								action="${pageContext.request.contextPath}/admin/student/edit"
								method="post">
								<div class="form-group">
									<label for="exampleInputId">Student Id</label> <input
										class="form-control" name="id" id="exampleInputId" type="text"
										value="${sedit.get(0).id}" readonly>
								</div>
								<div class="form-group">
									<label for="exampleInputTitle">Student Name</label> <input
										class="form-control" name="name" id="exampleInputTitle"
										type="text" value="${sedit.get(0).name}">
								</div>
								<div class="form-group">
									<label>Student Country</label> <select name="country"
										class="form-control">
										<option
											<c:if test="${sedit.get(0).country.equals('Nepal')}">selected</c:if>>Nepal</option>
										<option
											<c:if test="${sedit.get(0).country.equals('India')}">selected</c:if>>India</option>
										<option
											<c:if test="${sedit.get(0).country.equals('Srilanka')}">selected</c:if>>Srilanka</option>
										<option
											<c:if test="${sedit.get(0).country.equals('America')}">selected</c:if>>America</option>

									</select>
								</div>

								<div class="form-group">

									<label>Student Gender</label> <input name="gender"
										class="form-control" type="radio" value="Male"
										<c:if test="${sedit.get(0).gender.equals('Male')}">checked</c:if>>Male
									<input name="gender" class="form-control" type="radio"
										value="Female"
										<c:if test="${sedit.get(0).gender.equals('Female')}">checked</c:if>>Female

								</div>

								<div class="form-group">

									<label>Student Hobbies</label>
									<input name="hobbies"
										type="checkbox" value="Coding"
										<c:if test="${sedit.get(0).hobby.contains('Coding')}">checked</c:if>>Coding

									<input name="hobbies" type="checkbox" value="Swimming"
										<c:if test="${sedit.get(0).hobby.contains('Swimming')}">checked</c:if>>Swimming

									<input name="hobbies" type="checkbox" value="Music"
										<c:if test="${sedit.get(0).hobby.contains('Music')}">checked</c:if>>Music

									<input name="hobbies" type="checkbox" value="Sports"
										<c:if test="${sedit.get(0).hobby.contains('Sports')}">checked</c:if>>Sports

									<input name="hobbies" type="checkbox" value="Dancing"
										<c:if test="${sedit.get(0).hobby.contains('Dancing')}">checked</c:if>>Dancing

								</div>

								<input type="submit" class="btn btn-primary btn-block"
									value="Update">
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
