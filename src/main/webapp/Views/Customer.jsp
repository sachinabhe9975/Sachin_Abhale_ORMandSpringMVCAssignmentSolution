<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Home page </title>
</head>
<body>


<h1 align="center" style="color:#4169E1" >Customer Relationship Management</h1>




<form>
	<table align="center" >
		<tr>
		
			<td ><a href="addCustomer?id=-1"><input type="button" value="Add Customer"  /> </a>
			
			
			</td>
	</table>
</form>

	

	${error}

	<table border="1" align="center"  weight="70%"
		height="70%" bgcolor="#ADD8E6">
		<tr style="color:#A52A2A;" >
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>


		<c:forEach items="${customer}" var="b">
			<tr>
				<td>${b.customer_id}</td>
				<td>${b.first_name}</td>
				<td>${b.last_name}</td>
				<td>${b.customer_Email }</td>
				
				
				<td><a href="addCustomer?id=${b.customer_id}">Update |</a>
				<a href="deleteCustomer?id=${b.customer_id} " onclick="return confirm('Are you sure you want to delete?')"> Delete</a></td>
				
			</tr>

		</c:forEach>
	</table>
</body>
</html>
