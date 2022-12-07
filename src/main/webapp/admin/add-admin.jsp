<%--
  Created by IntelliJ IDEA.
  User: My Pham
  Date: 12/6/2022
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Eyeglasses</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        body {
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        form {
            width: 75%;
        }
        .message {
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
<form method="post">
    <h1>Add New Eyeglasses</h1>
    <c:if test="${requestScope['message'] != null}">
        <p class="message">${requestScope['message']}</p>
    </c:if>
    <c:set var="e" value="${requestScope['eyes']}"></c:set>
    <div class="row mb-3 mt-5">
        <label for="id" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="id" name="id">
        </div>
    </div>
    <div class="row mb-3 mt-5">
        <label for="name" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name">
        </div>
    </div>
    <div class="row mb-5">
        <label for="price" class="col-sm-2 col-form-label" >Price</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="price" name="price">
        </div>
    </div>
    <div class="row mb-5">
        <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="quantity" name="quantity">
        </div>
    </div>
    <div class="row mb-5">
        <label class="form-label" for="customFile">Choose image</label>
        <input type="file" class="form-control" id="customFile" name="image"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
