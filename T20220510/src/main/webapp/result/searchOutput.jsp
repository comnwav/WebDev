<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회결과</title>
</head>
<body>

	<h3>조회결과페이지</h3>
	
	<c:choose>
		<c:when test="${empty book}">회원정보가 없습니다.</c:when>
		<c:otherwise>
			<table border="1">
				<thead>
					<tr>
						<th>도서코드</th>
						<th>제목</th>
						<th>저자</th>
						<th>출판사</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td>${book.bookCode}</td>
					<td>${book.bookTitle}</td>
					<td>${book.bookAuthor}</td>
					<td>${book.bookPress}</td>
					<td>${book.bookPrice}</td>
					</tr>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	
    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>
</html>