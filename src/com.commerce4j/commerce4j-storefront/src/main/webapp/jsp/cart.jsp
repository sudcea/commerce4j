<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/license.jsp" flush="true" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  
    <title></title>
	<jsp:include page="include/javascript.jsp" flush="true" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
 </head>
 <body>
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 		<div id="d_body">
 		
 			<h1><fmt:message key="cart.heading" /></h1>
 			<fmt:message key="cart.message" />
 			
 			
 			<table class="listings" width="100%" cellspacing="0">
		
			<tr>
				<th width="120">Imagen</th>
				<th>T&iacute;tulo / Descripci&oacute;n</th>
				<th width="100">Precio</th>
				<th width="100">Cantidad</th>
				<th width="100">Sub-Total</th>
			</tr>
		
			<c:set var="count" value="0"/>
			<c:forEach items='${sessionScope.cart}' var="cart" varStatus="status">
			<tr>
				<td valign="top" align="center">
					<img src="images/img_not_available.png" />
				</td>
				<td valign="top">
					<c:out value="${cart.item.itemTitle}" />
					<div class="gray smaller">
						<c:out value="${cart.item.itemDesc}" />
					</div>
				</td>
				<td>
					<c:out value="${cart.item.currency.currencyAbrev}" />
					<c:out value="${cart.item.currency.currencySymbol}" />
					<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${cart.item.itemPrice}"    />
				</td>
				<td><c:out value="${cart.cartQuantity}" /></td>
				<td>
					<c:out value="${cart.item.currency.currencyAbrev}" />
					<c:out value="${cart.item.currency.currencySymbol}" />
					<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${cart.cartSubTotal}"    />
				</td>
			</tr>
			</c:forEach>
			</table>
 			
 		</div>
 	</td>
 	<td width="15%" valign="top">
 		<jsp:include page="include/featured.jsp" flush="true" />
 		<br/>
 		<jsp:include page="include/adsense.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 	
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>
