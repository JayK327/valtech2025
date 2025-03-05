<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.Employee" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department Details</title>
</head>
<body>

<%--     <p>Counters = ${counters}</p>
    <p>Current Dept = ${current}</p> --%>
    Counters = ${counters}
    Current Department=${current}

    <form action="depts" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td>
                <input type="text" name="id" value="${dept.id}" readonly/>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                <input type="text" name="name" value="${dept.name}"/>
                </td>
            </tr>
            <tr>
                <td>Location</td>
                <td>
                <input type="text" name="location" value="${dept.location}"/>
                </td>
            </tr>
          	<tr>
                <td >
                    <a href="depts?operation=Update&id=${dept.id}">Update</a>
                    <a href="depts?operation=Delete&id=${dept.id}">Delete</a>
                </td>
            </tr>
            <tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="operation" value="First" />
                    <input type="submit" name="operation" value="Previous" />
                    <input type="submit" name="operation" value="Next" />
                    <input type="submit" name="operation" value="Last" />
<!--                     <input type="submit" name="operation" value="Reset"/> -->
                </td>
            </tr>
            <tr>
                <td >
                    <a href="depts?operation=new">Create New</a>
                    <input type="submit" name="operation" value="Cancel"/>
                </td>
            </tr>
        </table>
		
		<h1>---------------Current Department Employees-------------------</h1>
        <table>
        	<tr>
		        <th>Id</th>
		        <th>Name</th>
		        <th>Age</th>
		        <th>Gender</th>
		        <th>Salary</th>
		        <th>Level</th>
		        <th>Experience</th>
		        <th>Dept_id</th>
   		    </tr>
   		    <%
   				 List<Employee> emps = (List<Employee>) session.getAttribute("employeeByDept");
    			for (Employee emp : emps) {
			%>  
		    <tr>
		        <td><%= emp.getId() %></td>
		        <td><%= emp.getName() %></td>
		        <td><%= emp.getAge() %></td>
		        <td><%= emp.getGender() %></td>
		        <td><%= emp.getSalary() %></td>
		        <td><%= emp.getExperience() %></td>
		        <td><%= emp.getLevel() %></td>
		        <td><%= emp.getDeptid() %></td>
		    </tr>
			<% 
			    }
			%>

           <%--  <c:forEach items = "${employeeByDept}" var = "e">
                <tr>
                    <td><c:out value="${e.id}"></c:out></td>
                    <td>${e.name}</td>
                    <td>${e.age}</td>
                    <td>${e.gender}</td>
                    <td>${e.salary}</td>
                    <td>${e.exp}</td>
                    <td>${e.level}</td>
                    <td>${e.deptid}</td>
                </tr>
            </c:forEach> --%>

            
        </table>
    </form>

<%--     <jsp:include page="SortingPage.jsp">
        <jsp:param name="typeofmeth" value="depts" />
        <jsp:param name="mode" value="depts" />
    </jsp:include> --%>

</body>
</html>
