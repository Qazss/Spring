<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<h4>Добавить продукт</h4>
		<form:form action="/product/create" modelAttribute="product">
		    title: <form:input path="title" />
		    <br>
		    cost: <form:input path="cost" />
		    <br>
		    <input type="submit" value="Submit" />
		</form:form>
		<hr>
		<h4>Удалить продукт</h4>
		<form action="/product/delete" method="POST">
		    id: <input type="number" name="deleteNumber" />
		    <br>
		    <input type="submit" value="Submit" />
		</form>
	</body>
</html>