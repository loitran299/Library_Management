<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/readers//borrowbooks.css">
    <link rel="stylesheet" href="/css/readers//addbooks.css">
    <title>Mượn sách</title>
</head>
<body>
<div class="container flex">
    <div class="header flex">
        <div class="page-title">Thêm sách vào phiếu mượn</div>
    </div>
    <div class="main flex">
        <div class="command">
            <span>Chọn sách</span>
            <input type="text" placeholder="search..." class="input-search" id="input-search">
        </div>
        <table class="grid">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên sách</th>
                <th>Tình trạng</th>
                <th>Thể loại</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="tbody1">
            </tbody>
        </table>

        <div class="main flex">
            <div class="command">
                <span>Sách đã chọn</span>
            </div>
            <table class="grid">
                <thead>
                <tr>
                    <th>Mã</th>
                    <th>Tên sách</th>
                    <th>Tình trạng</th>
                    <th>Thể loại</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="tbody2">
                </tbody>
            </table>
            <div class="bottom">
                <a href="add-borrow" class="btn-page" id="backToBorrow">Quay lại</a>
                <a href="" class="btn-page">Lưu</a>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/js/librarian/addbooks.js"></script>
</html>