<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- Above is for Adding Support for Spring Security JSP Tag Library to JSP Page. -->

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the luv2code company home page!
	</p>
	
	<hr>
	
	<!-- display user name and role of current (logged in) user -->
	
	<p>
		User: <security:authentication property="principal.username" /> <!-- 'principal.username' will display user id of logged in user. -->
		<br><br>
		Role(s): <security:authentication property="principal.authorities" /> <!-- 'principal.authorities' will display list of roles of logged in user. -->
	</p>
	
	<hr>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









