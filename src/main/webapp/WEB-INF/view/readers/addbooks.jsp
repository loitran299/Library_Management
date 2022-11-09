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
            <input type="text" placeholder="search..." class="input-search">
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
            <tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <a href="">Chi tiết</a>
                </td>
                <td>
                    <button class="btn-page">Thêm</button>
                </td>
            </tr>
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
                <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="" class="btn-page bg-red">Xóa</a>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="bottom">
                <a href="add-borrow" class="btn-page">Quay lại</a>
                <a href="" class="btn-page">Lưu</a>
            </div>
        </div>
    </div>
    </div>
</body>
</html>