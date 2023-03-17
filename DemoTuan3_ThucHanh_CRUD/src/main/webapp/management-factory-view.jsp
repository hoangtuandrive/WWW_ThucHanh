<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.demomvc.entities.Manufacturer" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 04/03/2023
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% List<Manufacturer> lsManufacturer =(List<Manufacturer>)session.getAttribute("maunfactories"); %>
    <h2>Xin chao</h2>
    <br/>
    <table border="1" width="80%" align="center">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Website</th>
        </tr>
        <% for (Manufacturer manu : lsManufacturer) {%>
            <tr>
                <td><%= manu.getId() %></td>
                <td><%= manu.getManName() %></td>
                <td><%= manu.getManContactName() %></td>
                <td><%= manu.getManContactEmail() %></td>
                <td><%= manu.getManContactPhone() %></td>
                <td><%= manu.getManWebsite() %></td>
                <td><a href="ManufacturerController?action=delete_user&id=<%=manu.getId()%>"
<%--                       onclick='if(confirm("Are you sure to execute this action?"))--%>
<%--                               {window.open("ManufacturerController?action=delete_user&id=<%=manu.getId()%>");window.close();}'--%>
                >Delete</a></td>
                <td><a href="ManufacturerController?action=update_manufactory_view&id=<%=manu.getId()%>">Update</a></td>
            </tr>
        <% } %>

    </table>
    <a href="ManufacturerController?action=add_manufacturer_view">Add Manufacturer</a>
</body>
</html>
