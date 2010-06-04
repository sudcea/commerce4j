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
	<script type="text/javascript">
		function update_cart() {
			// ajax controller call
			new Ajax.Request('cart.jspa?aid=update',  {
				method: 'post',
				parameters: $('frmCart').serialize(),
				onComplete: function(transport) {
				 	response = transport.responseText.evalJSON();
				 	alert(response);
//					if (response.responseCode === 'success') 
//						process_registered_user(response.userId); 
//					else if (response.responseCode === 'failure') 
//						display_form_messages('d_msgs', response.errors, 'errors', true);
				},
				
				onFailure: function(transport) {
					alert('Error de Transporte');
				}
			});
		}
	</script>
 </head>
 <body>
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 		<div id="d_body">
 		
 			<h1><fmt:message key="cart.heading" /></h1>
 			<fmt:message key="cart.message" />
 			
 			<table width="100%">
 			<tr>
 			<td width="50%">
 				<input type="button" value="Imprimir" />
 			</td>
 			<td width="50%">
	 			<div align="right">
			 		<input type="button" value="Actualizar" onclick="update_cart()" />
			 		<input type="button" value="Comprar" />
			 	</div>
 			</td>
 			</tr>
 			</table>
 			<br/>
                        <form id="frmCart" action="cart.jspa">
 			<table class="listings" width="100%" cellspacing="0" border="0">
		
			<tr>
				<th width="120">Imagen</th>
				<th>T&iacute;tulo / Descripci&oacute;n</th>
				<th width="100">Precio</th>
				<th width="100">Cantidad</th>
				<th width="100">Sub-Total</th>
			</tr>
		
			<c:set var="count" value="0"/>
			<c:set var="total" value="${0}"/>
			<c:forEach items='${sessionScope.cart}' var="cart" varStatus="status">
			<tr>
				<td valign="top" align="center">
					<img src="images/img_not_available.png" alt="" />
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
				<td>
					<input name="qty_${cart.item.itemId}" type="text" value="${cart.cartQuantity}" size="5" />
				</td>
				<td align="right" nowrap="nowrap">
					<c:out value="${cart.item.currency.currencyAbrev}" />
					<c:out value="${cart.item.currency.currencySymbol}" />
					<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${cart.cartSubTotal}"    />
				</td>
			</tr>
			<c:set var="total" value="${total + cart.cartSubTotal}"/>
			</c:forEach>
			<c:choose>
			<c:when test="${total > 0}">
			<tr>
				<td colspan="5"><hr class="separator"/></td>
			</tr>
			
			<tr>
				<td align="right" colspan="4">Total</td>
				<td align="right" nowrap="nowrap">
					
					USD $ <fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${total}" />
				</td>
			</tr>
			</c:when>
			<c:otherwise>
			<tr>
				<td colspan="5">Actualmente no se han agregado art&iacute;culos al carrito de compras</td>
			</tr>
			</c:otherwise>
			</c:choose>
			</table>
 			</form>
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
