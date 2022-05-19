<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>session2.jsp</title>
</head>
<body>
<%
String id = (String) session.getAttribute("id");
String pass= (String) session.getAttribute("pass");

out.print("<h3>id: " + id + "</h3>");
out.print("<h3>pass: " + pass + "</h3>");
%>
</body>
</html>