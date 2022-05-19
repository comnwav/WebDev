<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

	<h3>도서삭제조회</h3>
	<form action="../searchBook.do" method="get">
		<input type="text" name="bookCode" id=""><br> <input
			type="hidden" name="job" value="remove"> <input type="submit"
			value="조회">
	</form>

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
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>${book.bookCode}</td>
						<td>${book.bookTitle}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.bookPress}</td>
						<td>${book.bookPrice}</td>
						<td>
						<form action="${pageContext.servletContext.contextPath}/removeBook.do" method="post">
						<input type="hidden" name="code" value="${book.bookCode}">
							<input type="submit" value="삭제">
						</form>
						</td>
					</tr>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>