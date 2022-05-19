<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>memberSearch.jsp</title>
</head>

<body>
	${error }
	<h3>회원정보검색</h3>
	<form action="${pageContext.servletContext.contextPath}/memberSearch.do" method="get">
		<label for="id">조회아이디</label> 
		<input type="text" name="id" id="id"><br>
		<input type="hidden" name="job" value="search">
		<input type="submit" value="Search">
	</form>
	<a href="${pageContext.servletContext.contextPath}/index.jsp">홈으로</a>
</body>

</html>