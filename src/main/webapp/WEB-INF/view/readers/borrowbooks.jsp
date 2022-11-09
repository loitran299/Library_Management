<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/readers/borrowbooks.css">
    <title>Mượn sách</title>
</head>
<body>
<div class="container flex">
    <div class="header flex">
        <div class="page-title">Mượn sách</div>
    </div>
    <div class="main flex">
        <div class="command">
            <span>Các phiếu mượn đã đăng ký</span>
            <a href="add-borrow" class="btn-page">Thêm phiếu mượn</a>
        </div>
        <table class="grid">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Số lượng sách</th>
                <th>Ngày mượn</th>
                <th>Ngày dự trả</th>
                <th>Trạng thái</th>
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
            <a href="home-readers" class="btn-page">Về trang chủ</a>
        </div>
    </div>
</div>
</body>
</html>