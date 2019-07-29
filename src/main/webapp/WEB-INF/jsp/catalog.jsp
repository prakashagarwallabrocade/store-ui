<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="../resources/styles.css" />" rel="stylesheet">

<head>
<title>My Store</title>
</head>
<body>
	<form action="/cart" method="post">
		<div class="divTable greyGridTable">
			<div class="divTableHeading">
				<div class="divTableRow">
					<div class="divTableHead">select</div>
					<div class="divTableHead">Product Name</div>
					<div class="divTableHead">Price</div>
				</div>
			</div>
			<div class="divTableBody">
				<c:forEach var="category" items="${catalog.categories}">
				
					<div class="divTableRow" style="background-color: pink" >
						category: <c:out value="${category.name}" />
					</div>
					<c:forEach var="product" items="${category.products}">
						<div class="divTableRow">
							<div class="divTableCell">
								<input type="checkbox" name="selectedProds"
									value="${product.productId}">
							</div>
							<div class="divTableCell">
								<c:out value="${product.name}" />
							</div>
							<div class="divTableCell">
								<c:out value="${product.price}" />
							</div>
						</div>
					</c:forEach>
				</c:forEach>
			</div>

		</div>





		<input type="submit" value="Add to cart" />
	</form>
</body>

</html>