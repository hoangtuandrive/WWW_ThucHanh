<%@ page import="iuh.fit.demomvc.entities.Product" %>
<%@ page import="iuh.fit.demomvc.entities.Manufacturer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 08/03/2023
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Product product = (Product) session.getAttribute("ProductUpdate"); %>
<% List<Manufacturer> lsManufacturer =(List<Manufacturer>)session.getAttribute("maunfactories"); %>
<form action="ProductController">
    <input type="hidden" name="action" value="update_product"/>
    <input type="hidden" name="id" value="<%=product.getProductId()%>">
    Name:<input type="text" name="name" value=<%=product.getProductName()%>>
    <br/>
    Description:<input type="text" name="description" value=<%=product.getDescription()%>>
    <br/>
    Manufacturer:
    <select name="manufacturer">
        <% for (Manufacturer manu : lsManufacturer) { %>
            <option <%= manu.getId()==product.getManuf().getId() ? "selected" : ""%> value=<%=manu.getId()%>><%=manu.getId()%>. <%=manu.getManName()%></option>
        <% } %>
    </select>
    <br/>
    <button type="submit">UPDATE Product</button>
</form>
</body>
</html>
