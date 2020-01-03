<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		href="Showcart">Cart</a> </nav> </header>
	<div>
		<h3>Menu Items</h3>
		<h4>Item added to Cart Successfully</h4>
		<table cellspacing="10px" cellpadding="5px">
			<tr>
				<th class="al-left">Name</th>
				<th class="al-right">Price</th>
				<th class="al-mid">Active</th>
				<th class="al-mid">Date of Launch</th>
				<th class="al-mid">Free Delivery</th>
				<th class="al-mid">Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td class="al-left">${menu.name }</td>
					<td class="al-right">Rs.${menu.price }</td>
					<td class="al-mid">${menu.active }</td>
					<td class="al-mid">${menu.dateOfLaunch }</td>
					<td class="al-mid">${menu.category }</td>
					<td class="al-mid">${menu.freeDelivery }</td>
					<td class="al-mid"><a href="AddToCart?menuItemId=${menu.id }"
						target="_blank">Edit </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<footer> <span id="cpw">Copyright@2019</span> </footer>