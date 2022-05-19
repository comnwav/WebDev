<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>반가워유~!</h3>

<%

// 자바코드를 쓸 수 있다.
// jsp 파일이 자바 class 파일로 내부적으로 변환되기 때문에
String name = "홍길동";
out.println("<h3>" + name + "</h3>");

// 내장객체
// form 태그의 name이 parameter 임
String id = request.getParameter("user_id");
String name2 = request.getParameter("user_name");
out.println("입력값:" + id + ", name:" + name2);
// 페이지에서 페이지로 데이터를 넘기는 방식으은 form 태그가 유일하다


%>

<a href="/student.do">Student Servlet</a>

</body>
</html>