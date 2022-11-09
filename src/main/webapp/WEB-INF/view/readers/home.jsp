<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/home.css">
    <title>Trang chủ độc giả</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="logo">TRANG CHỦ ĐỘC GIẢ</div>
        <div class="user">
            <div class="username">${user.fullName}</div>
            <a href="/login" class="btn-logout">Đăng xuất</a>
        </div>
    </div>
    <div class="main">
        <a href="borrow-books" class="btn-page">Mượn sách</a>
    </div>
</div>
</body>
</html>