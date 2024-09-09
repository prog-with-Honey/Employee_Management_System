<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Employee Insertion Page</title>
</head>
<body style="text-align: center; background-color: #85929e;">
	<h1>Add New Employee</h1>
	
	<form action="addEmployee" method="get">
		Employee Name :	<input type="text" name="ename"><br><br>
		Employee Contact : <input type="text" name="contact"><br><br>
		
		<input type="submit" value="Submit"><br><br>
		
		<a href="display_employee_details">Show Employee Details</a><br><br>
		
		<a href="display_employee">Show Employee</a><br><br>
	
	</form>
</body>
</html>