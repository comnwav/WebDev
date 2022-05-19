<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>memberResult/memberListOutput.jsp</title>
</head>


<body>
	<c:choose>
		<c:when test="${empty all}">회원정보가 없습니다.</c:when>
		<c:otherwise>
			<table border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>비밀번호</th>
						<th>프로필사진</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${all }" var="member">
					<tr>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.pwd}</td>
					<td>
					<c:choose>
					<c:when test="${!empty member.profile}">
					<img src="${pageContext.servletContext.contextPath}/upload/${member.profile}" width="50" height="50"></img>
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
					</c:choose>
					</td>
					
					<td>
					<c:if test="${!empty member.profile}">
					<img src="${pageContext.servletContext.contextPath}/upload/${member.profile}" width="50" height="50"></img>
					</c:if>
					</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>