<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서수정조회</h3>
    <form action="${pageContext.servletContext.contextPath}/searchBook.do" method="get">
        <input type="text" name="bookCode" id=""><br>
        <input type="hidden" name="job" value="modify">
        <input type="submit" value="조회">
    </form>
    
    <!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
    
    <c:choose>
		<c:when test="${empty book}">조회결과가 없습니다.</c:when>
		<c:otherwise>
			<h3>회원정보수정</h3>
			
			<form action="${pageContext.servletContext.contextPath}/modifyBook.do" method="post">
				<label for="bookCode">BookCode</label>
				<input type="text" name="code" id="bookCode" readonly value="${book.bookCode}"><br>
				<label for="bookTitle">Title</label>
				<input type="text" name="title" id="bookTitle" value="${book.bookTitle}"><br>
				<label for="bookAuthor">Author</label>
				<input type="text" name="author" id="bookAuthor" value="${book.bookAuthor}"><br>
				<label for="bookPress">Press</label>
				<input type="text" name="press" id="bookPress" value="${book.bookPress}"><br>
				<label for="bookPrice">Price</label>
				<input type="number" name="price" id="bookPrice" value="${book.bookPress}"><br>

				<input type="submit" value="수정">
				
			</form>
		</c:otherwise>
	</c:choose>

    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>