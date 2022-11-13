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
    <link rel="stylesheet" href="/css/readers/borrowbooks.css">
    <title>Mượn sách</title>
</head>
<body>
<div class="container flex">
    <div class="header flex">
        <div class="page-title">Nhận sách</div>
    </div>
    <div class="main flex">
        <div class="command">
            <span>Các phiếu mượn chờ</span>
            <input type="text" placeholder="search..." class="input-search" id="input-search" style="height: 32px; width: 200px; padding-left: 8px">
        </div>
        <table class="grid">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Số lượng sách</th>
                <th>Ngày mượn</th>
                <th>Người mượn</th>
                <th>Ngày dự trả</th>
                <th>Trạng thái</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="tbd">
            </tbody>
        </table>
        <div class="bottom">
            <a href="/book-management" class="btn-page">Quay lại</a>
        </div>
    </div>
</div>
</body>
<script src="/js/librarian/receivebook.js"></script>
</html>