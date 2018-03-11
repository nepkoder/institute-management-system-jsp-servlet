<%--
  Created by IntelliJ IDEA.
  User: elwyn
  Date: 3/10/2018
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%@ include file="pageHeader.jsp" %>--%><!---for-static-webpage--->
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
            <li class="breadcrumb-item">
                <a href="">Course</a>
            </li>
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
                        <form action="${pageContext.request.contextPath}/admin/course/edit" method="post">
                            <div class="form-group">
                                <label for="exampleInputId">Course Id</label>
                                <input class="form-control" name="cId" id="exampleInputId" type="text" value="${editDetails.get(0).id}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputTitle">Course Title</label>
                                <input class="form-control" name="cTitle" id="exampleInputTitle" type="text" value="${editDetails.get(0).title}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPrice">Course Price</label>
                                <input class="form-control" name="cPrice" id="exampleInputPrice" type="text" value="${editDetails.get(0).price}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputDuration">Course Duration</label>
                                <input class="form-control" name="cDuration" id="exampleInputDuration" type="text" value="${editDetails.get(0).duration}">
                            </div>
                            <input type="submit" class="btn btn-primary btn-block" value="Change">
                        </form>
                    </div>
                </div>
            </div>
        </div><!---row-close---->
    </div><!---container-fluid-close--->

    <jsp:include page="footer.jsp"></jsp:include>
</div><!---content-wrapper-close---->
</body>
</html>
