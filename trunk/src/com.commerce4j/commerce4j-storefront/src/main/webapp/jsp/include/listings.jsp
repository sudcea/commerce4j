<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${listings eq null}">
No se encontraron productos para esta categor&iacute;a
</c:if>

<c:if test="${listings ne null}">
<div class="container">
<table class="listings" width="100%" cellspacing="0">
	
	<tr>
		<th width="120">Imagen</th>
		<th>T&iacute;tulo / Descripci&oacute;n</th>
		<th width="100">Precio</th>
		<th>&nbsp;</th>
	</tr>
	
	
	<c:forEach items="${listings}" var="item">
	<tr>
		<td valign="top" align="center">
		<img src="images/img_not_available.png" />
		</td>
		<td valign="top">
			<c:out value="${item.itemTitle}" />
			<div class="gray smaller"><c:out value="${item.itemDesc}" /></div>
		</td>
		<td><c:out value="${item.itemPrice}" /></td>
	</tr>
	</c:forEach>

</table>
</div>
</c:if>