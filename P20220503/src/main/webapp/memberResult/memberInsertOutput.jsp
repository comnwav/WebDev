<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>memberResult/memberInsertOutput.jsp</title>
</head>
<body>
	<h3>${"Hello"}</h3>
	<h3>${3>1?'good':'bad'}</h3>
	<h3>${!empty "Hello"}</h3>
	<h3>${name}</h3>
	<h3><%=(String) request.getAttribute("name")%>가입이 완료되었습니다.</h3>
	<h3>${name}님 가입이 완료되었습니다.</h3>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>