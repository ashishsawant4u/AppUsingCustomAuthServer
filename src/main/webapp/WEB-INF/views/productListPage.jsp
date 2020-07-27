<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<h3>${title}</h3>

	<table>
		<c:forEach var="prod" items="${products}">
		<tr>
			<td>${prod.productCode}</td>
			<td>${prod.name}</td>
			<td>${prod.description}</td>
			<td>${prod.unitPrice}</td>
		</tr>
		</c:forEach>
	</table>

