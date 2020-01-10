<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu item list Admin</title>
<link href="./style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header> <span id="title">truYum</span> <img
		src="./images/truyum-logo-light.png" alt="logo" id="logo" /> <nav>
	<a id="menu" href="ShowMenuItemListAdmin">Menu</a> </nav> </header>
	<div>
		<h3>Menu Items</h3>
		<table cellspacing="10px" cellpadding="5px">
			<tr>
				<th class="al-left">Name</th>
				<th class="al-right">Price</th>
				<th class="al-mid">Active</th>
				<th class="al-mid">Date of Launch</th>
				<th class="al-mid">Category</th>
				<th class="al-mid">Free Delivery</th>
				<th class="al-mid">Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td class="al-left">${menu.name }</td>
					<td class="al-right">Rs.${menu.price }</td>
					<td class="al-mid"><c:if test="${menu.active }">Yes</c:if> <c:if
							test="${!menu.active }">No</c:if></td>
					</td>
					<td class="al-mid"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${menu.dateOfLaunch }"></fmt:formatDate></td>
					<td class="al-mid">${menu.category }</td>
					<td class="al-mid"><c:if test="${menu.freeDelivery }">Yes</c:if>
						<c:if test="${!menu.freeDelivery }">No</c:if></td>
					<td class="al-mid"><a
						href="ShowEditMenuItem?menuItemId=${menu.id }" target="_blank">Edit
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> <span id="cpw">Copyright@2019</span> </footer>
</body>
</html>