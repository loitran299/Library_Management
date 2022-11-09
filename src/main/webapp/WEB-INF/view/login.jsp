<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/register.css">
    <link rel="stylesheet" href="/css/main.css">
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <div class="overlay">
        <div class="content">
            <div class="register">
                <h3>Đăng Nhập</h3>
                <form action="/login" method="post">
                    <div class="form-row">
                        <label for="username">Tên đăng nhập</label>
                        <input type="text" name="username" id="username">
                    </div>
                    <div class="form-row">
                        <label for="password">Mật khẩu</label>
                        <input type="password" name="password" id="password">
                    </div>
                    <input type="submit" class="btn-submit btn-blue" value="Đăng nhập">
                </form>
                <div class="form-bottom">
                    <a href="/register">Đăng ký</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>