<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="FileUploadDBServlet"
		enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" size="50" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" size="50" /></td>
			</tr>
			<tr>
				<td>Portrait Photo:</td>
				<td><input type="file" name="photo" size="50" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>