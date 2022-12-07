<%--
  Created by IntelliJ IDEA.
  User: My Pham
  Date: 12/5/2022
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        td, th {
            text-align: center;
            vertical-align: middle;
        }
        .col-4 {
            width: 33.33333333% !important;
        }
    </style>
</head>
<body>
<h1 class="container-fluid p-0">List Admin</h1>
<div class="container-fluid p-0">
    <div class="row">
        <div class="col-4 input-group rounded">
            <form action="" method="get">
                <input type="search" name="search" class="rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button type="submit" class="border-0" value="Search">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>
        <div class="col-4">
            <a href="/adminServlet?action=add">
                <button class="btn btn-secondary">
                    Add new product
                </button>
            </a>
        </div>
    </div>
</div>

<c:set var="eyes" value="${requestScope['eyes']}"></c:set>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Image</th>
        <th scope="col" colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${eyes}" var="e">
        <tr>
            <th scope="row">${e.getId()}</th>
            <td>${e.getName()}</td>
            <td>${e.getPrice()}</td>
            <td>${e.getQuantity()}</td>
            <td>
                <img src="${e.getUrl()}" alt="" width="50" height="50">
            </td>
            <td>
                <a href="/adminServlet?action=edit&id=${e.getId()}">Edit</a>
            </td>
            <td>
                <div class="col-sm-10">
                    <a href="/adminServlet?action=delete&id=${e.getId()}">Delete</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://kit.fontawesome.com/4846f4e74e.js" crossorigin="anonymous"></script>
</html>