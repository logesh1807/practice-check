<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Menu Item</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span id="title">truYum</span> <img class="img"
		src="./images/truyum-logo-light.png" alt="logo" id="logo" /> <nav>
	<a id="menu" href="ShowMenuItemListAdmin" />Menu</a> </nav> </header>
	<div>
		<h3>Edit Menu Item</h3>
		<form class="cont" name="form" onsubmit="return validation()"
			method="post" action="EditMenuItem?id=${menu.id}">
			<table>
				<tr>
					<td colspan="4"><label for="txtName"> Name</label></td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="txtName" name="txtName"
						size="80" value="${menu.name }"></td>
				</tr>
				<tr>
					<td><label for="txtPrice">Rs.price </label></td>
					<td>active</td>
					<td><label for="txtDoL">dateOfLaunch </label></td>
					<td><label for="Category">category </label></td>
				</tr>
				<tr>
					<td><input type="textbox" id="txtPrice" name="txtPrice"
						class="txt-right" value="Rs.${menu.price }"></td>
					<td><label for="rdYes"><input type="radio" id="rdYes"
							name="rdYes" checked>Yes</label> <label for="rdno"><input
							type="radio" id="rdYes" name="rdYes">No</label></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${menu.dateOfLaunch }" var="DoL"></fmt:formatDate> <input
						type="text" id="DoL" name="DoL" value="${DoL }"></td>
					<td><select name="Category" id="Category">
							<option>Starters</option>
							<option>Main Course</option>
							<option>Dessert</option>
							<option>Drinks</option></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" id="cbDelivery"
						name="cbDelivery" checked><c:if test="${menu.freeDelivery }">Yes</c:if>
						<c:if test="${!menu.freeDelivery }">No</c:if></td>
				</tr>
				<tr>
					<td colspan="2"><input class="color" type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span>Copyright@2019</span> </footer>
</body>
</html>