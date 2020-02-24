<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<h2>All Products</h2>
		<ul>
		    <c:forEach var="item" items="${clients}">
		        <li>${item.id} ${item.name}</li>

		        <c:forEach var="item" items="${item.products}">
                    <li>${item.id} ${item.title} ${item.cost}</li>
                </c:forEach>
		    </c:forEach>
		</ul>
	</body>
</html>