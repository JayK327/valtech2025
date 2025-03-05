<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    
    <form action="depts" method="post">
        <table >
            <tr>
                <td>Id</td>
                <td>
                    <input type="text" name="id" value="${depts.id}"/>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${depts.name}"/>
                </td>
            </tr>
            <tr>
                <td>Location</td>
                <td>
                    <input type="text" name="location" value="${depts.location}"/>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="submit" name="operation" value="${mode}"/>
                    <button type="button" onclick="window.location.href='depts'">Cancel</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>