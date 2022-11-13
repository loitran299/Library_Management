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
    <link rel="stylesheet" href="/css/librarian/bookmanagement.css">

    <title>Trang chủ thủ thư</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="logo">QUẢN LÝ MƯỢN SÁCH</div>
    </div>
    <div class="main">
        <a href="/receive-book" class="btn-page">Độc giả nhận sách</a>
        <a href="/borrow-book" class="btn-page">Thêm phiếu mượn</a>
    </div>
    <div class="bottom">
        <a href="/home-librarian" class="btn-blue">Về trang chủ</a>
    </div>
</div>
</body>
</html>