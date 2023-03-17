
<%@ page import="iuh.fit.demomvc.entities.Manufacturer" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 05/03/2023
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% Manufacturer manufacturer = (Manufacturer) session.getAttribute("ManuUpdate"); %>
    <form action="ManufacturerController">
        <input type="hidden" name="action" value="update_manufacturer"/>
        <input type="hidden" name="id" value="<%=manufacturer.getId()%>">
        Name:<input type="text" name="name" value=<%=manufacturer.getManContactName()%>>
        <br/>
        Contact:<input type="text" name="contact" value=<%=manufacturer.getManContactName()%>>
        <br/>
        Email:<input type="text" name="email" value=<%=manufacturer.getManContactEmail()%>>
        <br/>
        Phone:<input type="text" name="phone" value=<%=manufacturer.getManContactPhone()%>>
        <br/>
        Website:<input type="text" name="website" value=<%=manufacturer.getManWebsite()%>>
        <br/>
        <button type="submit">UPDATE Manufacturer</button>
    </form>
</body>
</html>
