<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!-- Favicon-->
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
</head>

<body>
    <div class="d-flex" id="wrapper">
        <tiles:insertAttribute name="menu" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <tiles:insertAttribute name="header" />
            <!-- Page content-->
            <div class="container-fluid">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>

</html>