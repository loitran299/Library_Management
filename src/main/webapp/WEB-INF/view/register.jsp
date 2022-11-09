<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/main.css">
    <title>Đăng ký tài khoản</title>
</head>
<body>
<div class="container">
    <div class="overlay">
        <div class="content">
            <div class="register">
                <h3>Đăng ký</h3>
                    <form action="/register" method="post" id="formRegister">
                        <div class="form-row">
                            <label for="username">Tên đăng nhập</label>
                            <input type="text" name="username" id="username" required>
                        </div>
                        <div class="form-row">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" id="password" required>
                        </div>
                        <div class="form-row">
                            <label for="cfPassword">Nhập lại mật khẩu</label>
                            <input type="password" name="cfPassword" id="cfPassword" required>
                        </div>
                        <div class="form-row">
                            <label for="fullName">Họ tên</label>
                            <input type="text" name="fullName" id="fullName" required>
                        </div>
                        <div class="form-row">
                            <label for="email">Email</label>
                            <input type="text" name="email" id="email" required>
                        </div>
                        <div class="form-row">
                            <label for="phoneNumber">Số điện thoại</label>
                            <input type="text" name="phoneNumber" id="phoneNumber" required>
                        </div>
                        <input type="submit" class="btn-submit btn-blue" id="btnRegister" value="Đăng ký">
                    </form>
                    <div class="form-bottom">
                        <a href="/login">Đăng nhập</a>
                    </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>