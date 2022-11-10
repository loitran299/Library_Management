<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/readers//borrowbooks.css">
    <link rel="stylesheet" href="/css/readers//addborrow.css">
    <title>Mượn sách</title>
</head>
<body>
<div class="container flex">
    <div class="header flex">
        <div class="page-title">Thêm phiếu mượn</div>
    </div>
    <div class="main flex">
        <div class="row flex">
            <div>
                <div class="info-item">Mã độc giả: <span>...</span></div>
                <div class="info-item">Họ tên: <span>...</span></div>
            </div>
            <div class="date-picker">
                <label for="payDate">Ngày trả</label>
                <input type="date" name="payDate" id="payDate">
            </div>

        </div>
        <div class="command">
            <span>Các sách mượn</span>
            <a href="add-books" class="btn-page">Thêm sách</a>
        </div>
        <table class="grid">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên sách</th>
                <th>Tình trạng</th>
                <th>Thể loại</th>
                <th>Tác giả</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <a href="">Chi tiết</a>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="bottom">
            <a href="borrow-books" class="btn-page">Quay lại</a>
            <a href="" class="btn-page">Đăng ký</a>
        </div>
    </div>
</div>
</body>
<script src="/js/addborrow.js"></script>
</html>