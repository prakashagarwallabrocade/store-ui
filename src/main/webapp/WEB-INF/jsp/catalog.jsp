<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<title>My Store</title>
</head>
<body>

	<table>
	<tr>
					<td>select</td>
					<td>Product Name</td>
					<td>Price</td>
					<tr>
		<c:forEach var="category" items="${catalog.categories}">
			<tr>
				<td colspan="3"><font color="red"><c:out
							value="${category.name}" /></font></td>
			</tr>
			<c:forEach var="product" items="${category.products}">
				
					<td>
			<input type="checkbox">
					<td><font color="#00CC00"><c:out
								value="${product.name}" /></font></td>
					<td><font color="#00CC00"><c:out
								value="${product.price}" /></font></td>
				</tr></c:forEach>
			</tr>

		</c:forEach>
	</table>
</body>

</html>