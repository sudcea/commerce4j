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
	<script type="text/javascript" src="js/livepipe.js"></script>
	<script type="text/javascript" src="js/rating.js"></script>
	<script type="text/javascript">
		function afterLoad() {
		 var rating = new Control.Rating('rating',{value: 2,multiple:true});
		}
		 
	</script>
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
 </head>
 <body onload="afterLoad()">
 
 	<jsp:include page="/jsp/include/header.jsp" flush="true" />

 	<table width="100%">
 	<tr>
 	<td valign="top" width="200">
 		<div id="d_left">
 			<h3>Im&aacute;genes</h3>
 			
 			
 			<c:choose>
 			<c:when test="${numOfImages > 0}">
 			
	 			<div class="image" align="center">
	 				<img src="catalog.jspa?aid=image&item=${item.itemId}&image=1" alt="" />
	 			</div>
	 			<div class="bglight"  style="padding: 4px" align="right">
	 				<img src="images/resultset_previous.png" alt="" />
	 				<img src="images/resultset_next.png" alt="" />
	 				<img src="images/zoom.png" alt="" />
	 			</div>
	 		</c:when>
	 		<c:otherwise>
	 			
	 			<div style="width: 192px;height:192px;padding: 10px" class="bglight" align="center">
	 				<strong class="gray">Imagen No Disponible</strong>
	 			</div>
	 			
	 		</c:otherwise>	
 			
 			</c:choose>
 			
 		</div>
 	</td>
 	<td valign="top">
 		<div id="d_body">
 			
 			
 			<div class="container">
	 			<h3>Art&iacute;culo #${item.itemId}</h3>
	 			<div class="listingTitle">${item.itemTitle}</div>
	 			<table>
	 			<tr>
	 				<td align="right">Condici&oacute;n : </td>
	 				<td>${item.status.statusName}</td>
	 			</tr>
	 			<tr>
	 				<td align="right">Calificaci&oacute;n : </td>
	 				<td>
		 				<span id="rating" class="rating_container">  
						     <a href="#" class="rating_on"></a>  
						     <a href="#" class="rating_on"></a>  
						     <a href="#" class="rating_off"></a>  
						     <a href="#" class="rating_off"></a>  
						     <a href="#" class="rating_off"></a>  
						</span>
					</td>
	 			</tr>
	 			<tr>
	 				<td align="right">Descripci&oacute;n : </td>
	 				<td>${item.itemDesc}</td>
	 			</tr>
	 			</table>
	 			 
	 			
 				
 				<br/>
 				
 				<div class="container bglight">
	 			<div class="listingPrice">
	 				<span class="gray">Precio: </span>
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
 			
 			<div class="container ">
	 			<h3>Descripci&oacute;n y Caracter&iacute;sticas</h3>
	 		</div>
	 		
	 		<br/><br/>
	 		
	 		<div class="comments"><a name="comments">4</a></div>
	 		<h3>Comentarios</h3>
	 		
	 		<br/><br/>
	 		
	 		<ul>
 			<li>
 			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ac commodo enim. Nullam at velit a magna mollis gravida. Maecenas justo dui, pellentesque eget ultrices non, condimentum nec est. Fusce auctor rhoncus nisi, at sagittis urna gravida tincidunt. Suspendisse eget tellus ligula, nec adipiscing risus. In bibendum, nisl in euismod interdum, nulla ipsum euismod turpis, convallis rhoncus leo mauris sed nisl. Cras rhoncus volutpat tellus, a ultricies nisl imperdiet vel. Nulla placerat scelerisque molestie.
 			</li>
 			
 			<li>
 			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ac commodo enim. Nullam at velit a magna mollis gravida. Maecenas justo dui, pellentesque eget ultrices non, condimentum nec est. Fusce auctor rhoncus nisi, at sagittis urna gravida tincidunt. Suspendisse eget tellus ligula, nec adipiscing risus. In bibendum, nisl in euismod interdum, nulla ipsum euismod turpis, convallis rhoncus leo mauris sed nisl. Cras rhoncus volutpat tellus, a ultricies nisl imperdiet vel. Nulla placerat scelerisque molestie.
 			</li>
 			
 			<li>
 			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ac commodo enim. Nullam at velit a magna mollis gravida. Maecenas justo dui, pellentesque eget ultrices non, condimentum nec est. Fusce auctor rhoncus nisi, at sagittis urna gravida tincidunt. Suspendisse eget tellus ligula, nec adipiscing risus. In bibendum, nisl in euismod interdum, nulla ipsum euismod turpis, convallis rhoncus leo mauris sed nisl. Cras rhoncus volutpat tellus, a ultricies nisl imperdiet vel. Nulla placerat scelerisque molestie.
 			</li>
 			</ul>
 		</div>
 		
 		
 		
 		
 		
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