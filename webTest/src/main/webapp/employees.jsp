<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
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

<table>
<tr>
	<th>Id</th>
	<th> <a href="employees?operation=SortByName">Name</a></th>
	<th ><a href="employees?operation=SortByAge">Age</a> </th>
	<th ><a href="employees?operation=SortByGender">Gender</a></th>
	<th><a href="employees?operation=SortBySalary">Salary</a></th>
	<th><a href="employees?operation=SortByExperience">Experience</a></th>
	<th><a href="employees?operation=SortByLevel">Level</a></th>
	<th><a href="employees?operation=SortByDept">Deptid</a></th>
	<th>Actions</th>
</tr>



<!-- Loop through Employees for this Department -->
<c:forEach items="${emps}" var="e">
	<tr>
		<td><c:out value="${e.id}"></c:out></td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>${e.deptid}</td>
		<td>
			<a href="employees?operation=Update&id=${e.id}">Update</a>
			<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>
</c:forEach>

<!-- Add New Employee Link -->
<tr>
	<td colspan="7">
		<a href="employees?operation=new"> New Employee</a>
	</td>
</tr>

</table>

<hr></hr>

<jsp:include page="SortingPage.jsp" ></jsp:include>
<%-- 
Option=<%=request.getParameter("options") %> --%>
<%-- <table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
	<th>Experience</th>
	<th>Level</th>
</tr>
<%
	List<Employee> emps=(List<Employee>) request.getAttribute("emps");
	for(Employee e:emps) {
%>
	<tr>
		<td>
			<%= e.getId() %>
		</td>
		<td>
			<%= e.getName() %>
		</td>
		<td>
			<%= e.getAge() %>
		</td>
		<td>
			<%= e.getGender() %>
		</td>
		<td>
			<%= e.getSalary() %>
		</td>
		<td>
			<%= e.getExperience() %>
		</td>
		<td>
			<%= e.getLevel() %>
		</td>
	
	</tr>
		
<% 	} %> 
</table> --%>
</body>
</html>