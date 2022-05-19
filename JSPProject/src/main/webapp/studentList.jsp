<%@page import="java.util.List"%>
<%@page import="co.edu.StudentDAO"%>
<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>studentList.jsp</title>
</head>

<body>
	<table border="1">
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>영어</th>
			<th>수학</th>
		</thead>
		<tbody>
		<%
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.studentList();
		for (Student s : list) {
			out.print("<tr><td><a href='StudentGetServlet?cmd=search&user_id=" + s.getStudentNo() + "'>" + s.getStudentNo() + "</a></td>");
			out.print("<td>" + s.getStudentName() + "</td>");
			out.print("<td>" + s.getEngScore() + "</td>");
			out.print("<td>" + s.getKorScore() + "</td></tr>");
		}
		%>
		</tbody>
		
	</table>

	
	<script>

	</script>
	<hr>
	<a href="./form.jsp">입력화면</a>
</body>

</html>