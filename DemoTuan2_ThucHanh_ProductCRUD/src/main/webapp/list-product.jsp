<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Thực hành tuần 2</title>
</head>
<body>
<center>
    <h1>Product List</h1>
    <h2>
        <a href="product-form.jsp">Add New Product</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list-product.jsp">List All Products</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Products</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>ManufacturerId</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.manufacturerId}"/></td>
                <td>
                    <a href="edit-product?id=<c:out value='${product.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete-product?id=<c:out value='${product.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>