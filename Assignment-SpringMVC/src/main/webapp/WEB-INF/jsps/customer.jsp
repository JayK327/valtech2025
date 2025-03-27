<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="customer">
	<table>
		<tr>
			<td><input name="cusId" type="text" value="0" hidden="true"/></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input name="name" type="text"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input name="age" type="text"/></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input name="address" type="text"/></td>
		</tr>
		<tr>
			<td>Permanent Address</td>
			<td><input name="permanentAddress" type="text"/></td>
		</tr>
		<tr>
			<td>Customer Status</td>
			<td><input name="cusStatus" type="text"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="action" value="Add" type="submit"/>
				<input name="action" value="Cancel" type="submit"/>
			</td>
			
		</tr>
	</table>

</form>


<table>

	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Address</th>
		<th>Permanent Address</th>
		<th>Customer Status</th>
	</tr>
	<c:forEach items="${customer}" var = "c">
	<tr>
		<td>${c.cusId}</td>
		<td>${c.name}</td>
		<td>${c.age}</td>
		<td>${c.address}</td>
		<td>${c.permanentAddress}</td>
		<td>${c.cusStatus}</td>
	</tr>
	</c:forEach>


</table>


</body>
</html>