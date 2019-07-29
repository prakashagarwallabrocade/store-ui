<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="../resources/styles.css" />" rel="stylesheet">


<head>
<title>My Cart</title>
<script type="text/javascript">
	function onVisaCheckoutReady() {
		V
				.init({
					apikey : "I3KJLOCN1CQDPSIMAK1D21TPQiZVWmDq-Ql4UbXCCbcQghUqk",
					encryptionKey : "1D8IR5TUJ5VDLFRQ9XJV133hpPOUCXtMwJGJ0nT5iS_Rz6sds",
					paymentRequest : {
						currencyCode : "USD",
						subtotal : ${cart.totalValue},
						total : ${cart.totalValue}
					}
				});
		V.on("payment.success", function(payment) {
			document.write(" your payment is successful");
			console.log(JSON.stringify(payment));
		});
		V.on("payment.cancel", function(payment) {
			document.write("your payment is cancelled");
			console.log(JSON.stringify(payment));
		});
		V.on("payment.error", function(payment, error) {
			document.write("your payment has error" + JSON.stringify(error));
			console.log(JSON.stringify(error));
		});
	}
</script>

</head>
<body>

	<div class="divTable greyGridTable">
		<div class="divTableHeading">
			<div class="divTableRow">
				<div class="divTableHead">Product Name</div>
				<div class="divTableHead">Price</div>
			</div>
		</div>
		<div class="divTableBody">
			<c:forEach var="product" items="${cart.products}">
				<div class="divTableRow">
					<div class="divTableCell">
						<c:out value="${product.name}" />
					</div>
					<div class="divTableCell">
						<c:out value="${product.price}" />
					</div>
				</div>
			</c:forEach>

		</div>
		<div class="divTableFoot tableFootStyle">
			<div class="divTableRow">
				<div class="divTableCell">Total Price</div>
				<div class="divTableCell">${cart.totalValue}</div>
			</div>
		</div>
	</div>


	<div  style="margin-top:40px; margin-left: 20px" class="v-checkout-wrapper" >
		<img class="v-button" role="button"
			src="https://sandbox.secure.checkout.visa.com/wallet-services-web/xo/button.png">

	</div>

	<script type="text/javascript"
		src="https://sandbox-assets.secure.checkout.visa.com/
checkout-widget/resources/js/integration/v1/sdk.js">
		
	</script>
</body>

</html>