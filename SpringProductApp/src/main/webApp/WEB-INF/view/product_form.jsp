<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<body>
		<form:form action="form" modelAttribute="product">
		    title: <form:input path="title" />
		    <br>
		    cost: <form:input path="cost" />
		    <br>
		    <input type="submit" value="Submit" />
		</form:form>
	</body>
</html>