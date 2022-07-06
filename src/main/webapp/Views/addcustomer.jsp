<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color:#4169E1"> Customer Relationship Management</h1>



<form action="save" method="post">
<table align="center">
<h3 align="center" > Save customer <h3>
<tr>
<td> First Name</td><td><input type="text" value="${customer.first_name}" name="first_name" required  placeholder="First Name"/> </td></tr>
<tr>
<td> Last Name </td><td><input type="text" value="${customer.last_name}" name="last_name" required placeholder="Last Name"/> </td>
</tr>
<tr>
<td> Email</td><td><input type="text" value="${customer.customer_Email}" name="customer_Email" required placeholder="Email"/> </td>
</tr>

<tr>
<td colspan="2"><input type="hidden" value='${customer.customer_id}' name="customer_id"/><input type="submit" VALUE="Save"/></td></tr>
</table>>
</form>
<a href="list" style="display:block;text-align:center">back to list</a>
</body>
</html>