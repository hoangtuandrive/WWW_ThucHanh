<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 04/03/2023
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="ManufacturerController">
        <input type="hidden" name="action" value="add_manufacturer"/>
        Name:<input type="text" name="name">
        <br/>
        Contact:<input type="text" name="contact">
        <br/>
        Email:<input type="text" name="email">
        <br/>
        Phone:<input type="text" name="phone">
        <br/>
        Website:<input type="text" name="website">
        <br/>
        <button type="submit">ADD Manufacturer</button>
    </form>
</body>
</html>
