<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/jsp/include/license.jsp" flush="true" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  
    <title></title>
	<jsp:include page="/jsp/include/javascript.jsp" flush="true" />
	<script type="text/javascript" src="js/common.functions.js"></script>
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
 </head>
 <body>
 
 	<jsp:include page="/jsp/include/header.jsp" flush="true" />
 	

 	

 	<table width="100%">
 	<tr>
 	<td valign="top" width="200">
 		<div id="d_left">
 			
 			<h3>Im&aacute;genes</h3>
 			&nbsp;
 			
 		</div>
 	</td>
 	<td valign="top">
 		<div id="d_body">
 			
 			<h3>Item #${item.itemId}</h3>
 			<h2>${item.itemTitle}</h2>
 			<div>${item.itemDesc}</div>
 			
 			<br/>
 			<div class="container bglight">
 			
 				
 			
	 			<div class="listingPrice">
		 			<c:out value="${item.currency.currencyAbrev}" />
					<c:out value="${item.currency.currencySymbol}" />
					<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${item.itemPrice}"    />
	 			</div>
	 			
	 			
	 			<br/>
	 			
	 			<span class="smaller gray">Cantidad</span><br/>
 				<input type="text" size="5" maxlength="5" />
 				<input type="button" value="Comprar" onclick="add_to_cart('${item.itemId}',1, false)" />
 			</div>
 		</div>
 		
 		<br/>
 		
 		<h3>Descripci&oacute;n y Caracter&iacute;sticas</h3>
 		
 		
 		<h3>Comentarios de Usuarios</h3>
 		
 		
 		
 		
 	</td>
 	</tr>
 	</table>

 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="/jsp/include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>