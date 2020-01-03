<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Menu Item</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="title">truYum</span> <img class="img"
		src="./images/truyum-logo-light.png" alt="logo" id="logo" /> <nav>
	<a id="menu" href="ShowMenuItemListCustomer" />Menu</a> <a id="cart"
		href="ShowCart">Cart</a> </nav> </header>
	<div>
		<h3 class="cart">Cart</h3>
		<h4>${msg }</h4>
		<h4>Item removed from Cart Successfully</h4>
		<table cellspacing="10px" cellpadding="5px">
			<tr>
				<th class="al-left">Name</th>
				<th class="al-mid">Free Delivery</th>
				<th class="al-right">Price</th>
			</tr>
			<c:forEach items="${menuItemList }" var="menu">
				<tr>
					<td class="al-left">${menu.name }</td>
					<td class="al-mid"><c:if test="${menu.freeDelivery }">Yes</c:if>
						<c:if test="${!menu.freeDelivery }">No</c:if></td>
					<td class="al-right">Rs.${menu.price }</td>
					<td><a href="RemoveCart?menuItemId=${menu.id }">Delete</td>

				</tr>
			</c:forEach>
			<tr>
				<td class="al-left"></td>
				<th class="al-mid">Total</th>
				<th class="al-right">Rs.228.00</th>
			</tr>
		</table>
	</div>
	<footer> <span id="cpw">Copyright@2019</span> </footer>
</body>
</html>