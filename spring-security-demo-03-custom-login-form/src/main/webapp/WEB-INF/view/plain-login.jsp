<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Above, for using Spring form tags. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Above, for using JSTL -->

<html>

<head>
	<title>Custom Login Page</title>
	
	<style>
		.failed {
			color: red;
		}
	</style>
	
</head>

<body>

	<h3>My Custom Login Page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" > <!-- "/authenticateTheUser" is based on our SpringSecurityConfig file. -->
	
	
		<!-- Check for Login Error
			When we enter wrong username or password, Spring Security redirects us to same page 
			AND appends '?error' to the URL.
			SO, to show the error message to the user that they have entered wrong credentials, 
			We have to CHECK that appended 'error' parameter. -->
			
			<c:if test="${param.error != null}">
			
				<i class="failed">Sorry! You have entered invalid username/password.</i>
		
			</c:if>
			
	
		<p>
			User name: <input type="text" name="username" /> <!-- NOTE: We need to give here name as "username" only because that's the default values that Spring 
																		Security will look for while processing the form. -->
		</p>
		
		<p>
			Password: <input type="password" name="password" /> <!-- NOTE: We need to give here name as "password" only because that's the default values that Spring
																		   Security will look for while processing the form. -->
		</p>
	
		<input type="submit" value="Login" />
	
	</form:form>
	
</body>

</html>