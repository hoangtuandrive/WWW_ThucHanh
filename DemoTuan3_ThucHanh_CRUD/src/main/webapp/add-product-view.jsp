<%@ page import="iuh.fit.demomvc.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.demomvc.entities.Manufacturer" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 07/03/2023
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Manufacturer> lsManufacturer =(List<Manufacturer>)session.getAttribute("maunfactories"); %>
<form action="ProductController">

    <input type="hidden" name="action" value="add_product"/>
    Name:<input type="text" name="name">
    <br/>
    Description:<input type="text" name="description">
    <br/>
    Manufacturer:
    <select name="manufacturer">
        <% for (Manufacturer manu : lsManufacturer) { %>
            <option value=<%=manu.getId()%>><%=manu.getId()%>. <%=manu.getManName()%></option>
        <% } %>
    </select>
    <br/>
    <button type="submit">ADD Product</button>
</form>
</body>
</html>
