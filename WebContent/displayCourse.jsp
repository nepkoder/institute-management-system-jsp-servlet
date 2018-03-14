
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>

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
                <a href="${pageContext.request.contextPath}/admin/dashboard">Course</a>
            </li>
            <li class="breadcrumb-item active">Display</li>
        </ol>

        <!-- Example DataTables Card-->
        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table"></i> Course Information</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>Price</th>
                            <th>Duration</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>Price</th>
                            <th>Duration</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach items="${CourseData}" var="Course">
                        <tr>
                            <td>${Course.id}</td>
                            <td>${Course.title}</td>
                            <td>${Course.price}</td>
                            <td>${Course.duration}</td>
                            <td><a href="${cp}/admin/course/edit?id=${Course.id}">Edit</a></td>
                            <td><a href="${cp}/admin/course/delete?id=${Course.id}">Delete</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
    </div><!---container-fluid-close--->


    <jsp:include page="footer.jsp"></jsp:include>
</div><!---content-wrapper-close---->
</body>
</html>
