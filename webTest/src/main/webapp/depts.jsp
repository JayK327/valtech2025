<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department Details</title>
</head>
<body>

    <p>Counters = ${counters}</p>
    <p>Current Dept = ${current}</p>

    <form action="depts" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td>${dept.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${dept.name}</td>
            </tr>
            <tr>
                <td>Location</td>
                <td>${dept.location}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="operation" value="First" />
                    <input type="submit" name="operation" value="Previous" />
                    <input type="submit" name="operation" value="Next" />
                    <input type="submit" name="operation" value="Last" />
                </td>
            </tr>
        </table>

        <table>
            <tr>
                <th>Id</th>
                <th><a href="employees?operation=SortByNameDepts">Name</a></th>
                <th><a href="employees?operation=SortByAgeDepts">Age</a></th>
                <th><a href="employees?operation=SortByGenderDepts">Gender</a></th>
                <th><a href="employees?operation=SortBySalaryDepts">Salary</a></th>
                <th><a href="employees?operation=SortByExperienceDepts">Experience</a></th>
                <th><a href="employees?operation=SortByLevelDepts">Level</a></th>
                <th>Actions</th>
            </tr>

            <c:forEach items="${emps}" var="e">
                <tr>
                    <td><c:out value="${e.id}" /></td>
                    <td>${e.name}</td>
                    <td>${e.age}</td>
                    <td>${e.gender}</td>
                    <td>${e.salary}</td>
                    <td>${e.exp}</td>
                    <td>${e.level}</td>
                    <td>
                        <a href="employees?operation=update&id=${e.id}">Update</a>
                        <a href="employees?operation=delete&id=${e.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="7">
                    <a href="employees?operation=newEmp&current=${current}">New Employee</a>
                </td>
            </tr>
        </table>
    </form>

    <jsp:include page="SortingPage.jsp">
        <jsp:param name="typeofmeth" value="depts" />
        <jsp:param name="mode" value="depts" />
    </jsp:include>

</body>
</html>
