<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>memberSearchOutput.jsp</title>
</head>
<body>
		<c:if test="${!empty result}"><h4>${result}</h4></c:if>
		<c:if test="${!empty member}">
		<h4>${member.id } / ${member.name } / ${member.email } / ${member.pwd }</h4>
		</c:if>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>