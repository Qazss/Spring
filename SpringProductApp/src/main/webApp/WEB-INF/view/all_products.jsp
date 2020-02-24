<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<body>
		<h2>All Products</h2>
		<ul>
		    <c:forEach var="item" items="${products}">
		        <li>${item.id} ${item.title} ${item.cost}</li>
		    </c:forEach>
		</ul>
	</body>
</html>