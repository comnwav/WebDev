<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>memberUpdate.jsp</title>
</head>

<body>
	<h3>회원수정검색</h3>
	${error }
	<form action="${pageContext.servletContext.contextPath}/memberSearch.do" method="get">
		<label for="id">조회아이디</label>
		<input type="text" name="id" id="id"><br>
		<input type="hidden" name="job" value="update">
		<input type="submit" value="Search">
	</form>

	<c:choose>
		<c:when test="${!empty result }">
			<h3>${result }</h3>
		</c:when>
		<c:otherwise>
			<h3>회원정보수정</h3>
			<form action="${pageContext.servletContext.contextPath}/memberUpdate.do" method="post">
				<label for="id">ID</label>
				<input type="text" name="id" id="id" readonly value="${member.id}"><br>
				<label for="name">Name</label>
				<input type="text" name="name" id="name" value="${member.name}"><br>
				<label for="email">Email</label>
				<input type="email" name="email" id="email" value="${member.email}"><br>
				<label for="pwd">Password</label>
				<input type="text" name="pwd" id="pwd" value="${member.pwd}"><br>
				<input type="submit" value="수정">
			</form>
		</c:otherwise>
	</c:choose>
	
	<jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>

</html>