<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
  <c:if test="${product != null}">
  <form action="update-product" method="post">
    </c:if>
    <c:if test="${product == null}">
    <form action="insert-product" method="post">
      </c:if>
      <table border="1" cellpadding="5">
        <caption>
          <h2>
            <c:if test="${product != null}">
              Edit Product
            </c:if>
            <c:if test="${product == null}">
              Add New Product
            </c:if>
          </h2>
        </caption>
        <c:if test="${product != null}">
          <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
        </c:if>
        <tr>
          <th>Product Name: </th>
          <td>
            <input type="text" name="name" size="45"
                   value="<c:out value='${product.name}' />"
            />
          </td>
        </tr>
        <tr>
          <th>Product Description: </th>
          <td>
            <input type="text" name="email" size="45"
                   value="<c:out value='${product.description}' />"
            />
          </td>
        </tr>
        <tr>
          <th>Manufacturer ID: </th>
          <td>
            <input type="text" name="country" size="15"
                   value="<c:out value='${product.manufacturerId}' />"
            />
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="Save" />
          </td>
        </tr>
      </table>
    </form>
</div>
</body>
</html>