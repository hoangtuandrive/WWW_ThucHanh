<%@ page import="iuh.fit.demomvc.entities.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 07/03/2023
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% List<Product> lsProduct =(List<Product>)session.getAttribute("products"); %>
    <h2>Xin chao</h2>
    <br/>
    <table border="1" width="80%" align="center">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Deciption</th>
            <th>Manufacturer</th>
        </tr>
        <% for (Product pro : lsProduct) {%>
        <tr>
            <td><%= pro.getProductId() %></td>
            <td><%= pro.getProductName() %></td>
            <td><%= pro.getDescription() %></td>
            <td><%= pro.getManuf().getId() %>. <%=pro.getManuf().getManName()%></td>

            <td><a href="ProductController?action=delete_product&id=<%=pro.getProductId()%>"
            <%--                       onclick='if(confirm("Are you sure to execute this action?"))--%>
            <%--                               {window.open("ManufacturerController?action=delete_user&id=<%=manu.getId()%>");window.close();}'--%>
            >Delete</a></td>
            <td><a href="ProductController?action=update_product_view&id=<%=pro.getProductId()%>">Update</a></td>
        </tr>
        <% } %>

    </table>
    <a href="ProductController?action=add_product_view">Add Product</a>
</body>
</html>
