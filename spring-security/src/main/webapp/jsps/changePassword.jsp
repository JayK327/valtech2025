<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change your Password</title>
</head>
<body>
<form action="changePassword" method="post">
	<table>
		<tr>
			<td>
				Current Password
			</td>
			<input type="password" name="currentPassword"/>
		</tr>
		<tr>
			<td>
				New Password
			</td>
			<input type="password" name="newPassword"/>
		</tr>
		<tr>
			<td>
				Confirm Password
			</td>
			<input type="password" name="confirmPassword"/>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Change Passsword"/>
			</td>
		
		</tr>
	</table>

</form>

</body>
</html>