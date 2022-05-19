<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>memberUpdateOutput.jsp</title>
</head>
<body>
	<h3>${id }님의정보가 삭제되었습니다.</h3>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>