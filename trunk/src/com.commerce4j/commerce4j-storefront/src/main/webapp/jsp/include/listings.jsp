<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:if test="${listings ne null && param.view eq 'table'}">
<div class="container">
<table class="listings" width="100%" cellspacing="0">
	
	<tr>
		<th width="120">Imagen</th>
		<th>T&iacute;tulo / Descripci&oacute;n</th>
		<th width="100">Precio</th>
		<th>&nbsp;</th>
	</tr>
	
	<c:set var="count" value="0"/>
	<c:forEach items="${listings}" var="item" varStatus="status">
	<tr>
		<td valign="top" align="center">
			<img src="images/img_not_available.png" />
		</td>
		<td valign="top">
			<c:out value="${item.itemTitle}" />
			<div class="gray smaller">
				<c:out value="${item.itemDesc}" />
			</div>
		</td>
		<td>
			<c:out value="${item.currency.currencyAbrev}" />
			<c:out value="${item.currency.currencySymbol}" />
			<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${item.itemPrice}"    />
		</td>
		<td align="center">
			<input type="button" value="Comprar" />
		</td>
	</tr>
	<c:if test="${status.last}">
      <c:set var="count" value="${status.count}"/>
    </c:if>
	</c:forEach>
	
	<c:if test="${count eq 0}">
	<tr>
	<td colspan="4">No se encontraron productos para esta categor&iacute;a</td>
	</tr>
	</c:if>
</table>
</div>
</c:if>