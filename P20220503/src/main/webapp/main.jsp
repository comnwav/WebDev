<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>request.jsp</title>
</head>
<body>
	<%
	String id = (String) session.getAttribute("id");
	if (id == null) {
		// out.print("<button onclick='location.href=session.jsp'>로그인</button>");
	%>
	
	<button onclick='location.href="session.jsp"'>로그인</button>
	
	<%
	} else {
	%>	
	<h3><%=id %></h3>
	<button onclick='location.href="logout.do"'>로그아웃</button>
	<%
	}
	%>

</body>
</html>