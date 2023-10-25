<%@page import="com.key.SessionKey"%>
<%@page import="com.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Student Update</title>
</head>
<% StudentVO studentVO = (StudentVO)session.getAttribute(SessionKey.studentsToUploadKey);%>
<body>

	<form method="post" action="update">

		<input type="hidden" name="id" value="<%=studentVO.getId()%>"/><br/><br/><br/>
		
		<label for="FirstName">First Name</label>
		<input type="text" name="firstName" placeholder="<%=studentVO.getFirstName()%>" /><br /><br /><br />

		<label for="LastName">Last Name</label>
		<input type="text" name="lastName" placeholder="<%=studentVO.getLastName()%>" /><br /><br /><br />

		<label for="Age">Age</label>
		<input type="text" name="age" placeholder="<%=studentVO.getAge()%>" /><br /><br /><br />

		<input type="submit" value="Update" />

	</form>

</body>

</html>