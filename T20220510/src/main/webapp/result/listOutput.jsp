<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트.</title>
</head>

<body>
	<h3>조회결과페이지</h3>
	
	<c:choose>
		<c:when test="${empty list}">도서정보가 없습니다.</c:when>
		
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
					<c:forEach items="${list }" var="element">
					<tr>
					<td>${element.bookCode}</td>
					<td>${element.bookTitle}</td>
					<td>${element.bookAuthor}</td>
					<td>${element.bookPress}</td>
					<td>${element.bookPrice}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>
</body>

</html>