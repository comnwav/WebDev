<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>reponse.jsp</title>
</head>
<body>

    <%
    String id = (String) request.getAttribute("id");
    String name = (String) request.getAttribute("name");
    Student student = (Student) request.getAttribute("result");
    %>
    
    <h3>id: <%=id%></h3>
    <h3>name: <%=name%></h3>
    <h3>no: <%=student.getStudentNo() %></h3>
    <h3>name: <%=student.getStudentName() %></h3>
</body>
</html>