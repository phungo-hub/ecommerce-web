<%--
  Created by IntelliJ IDEA.
  User: My Pham
  Date: 12/5/2022
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        td, th {
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<h1>List Admin</h1>
<form action="/admin?action=search" method="post"></form>
<div class="input-group rounded">
    <input type="search" class="rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
    <span class="border-0" id="search-addon">
    <i class="fas fa-search" style="margin: .25rem"></i>
  </span>
</div>
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
    <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>
            <img src="img/img1.png" alt="" width="50" height="50">
        </td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    </tbody>
</table>
</body>
<script src="https://kit.fontawesome.com/4846f4e74e.js" crossorigin="anonymous"></script>
</html>