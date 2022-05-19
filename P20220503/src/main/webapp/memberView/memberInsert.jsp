<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>memberView/memberInsert.jsp</title>
</head>

<body>
    <h3>회원가입화면</h3>
    <form action="../memberInsert.do" method="post" enctype="multipart/form-data">
        <label for="id">아이디</label>
        <input type="text" name="id" id="id"><br>
        <label for="pwd">비밀번호</label>
        <input type="password" name="pwd" id="pwd"><br>
        <label for="">이름</label>
        <input type="text" name="name" id="name"><br>
        <label for="email">메일</label>
        <input type="email" name="email" id="email"><br>
        <label for="profile">이미지</label>
        <input type="file" name="profile" id="profile"><br>
        <input type="submit" value="추가"><br>
    </form>
    <jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>

</html>