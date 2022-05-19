<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>memberDelete.jsp</title>
</head>
<body>
 <h3>회원삭제검색</h3>
 	${error }
    <form action="${pageContext.servletContext.contextPath}/memberSearch.do" method="get">
        <label for="id">조회아이디</label>
        <input type="text" name="id" id="id"><br>
        <input type="hidden" name="job" value="search">
        <input type="submit" value="Search">
    </form>
    
    <jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>
</html>