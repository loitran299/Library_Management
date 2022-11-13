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
    <link rel="stylesheet" href="/css/bookdetail.css">
    <title>Document</title>
</head>
<body>
<div class="container flex">
    <div class="book-detail">
        <h1>${bookDetail.title.name}</h1>
        <h3>Mã sách:<span>${bookDetail.title.name}</span></h3>
        <h3>Tác giả:<span>${bookDetail.title.author.name}</span></h3>
        <h4>Tiểu sử:<span>${bookDetail.title.author.story}</span></h4>
        <h4>Thể loại:<span>${bookDetail.title.category.name}</span></h4>
        <h4>Ghi chú:<span>${bookDetail.notes}</span></h4>
    </div>
</div>
</body>
</html>