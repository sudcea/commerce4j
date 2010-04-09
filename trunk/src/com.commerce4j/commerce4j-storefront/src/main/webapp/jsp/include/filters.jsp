<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${listings ne null}">
<h3><strong>Herramientas</strong></h3>
<table class="block">
<tr>
<th>Opciones de B&uacute;squeda</th>
</tr>
<tr>
	<td class="blocktitle">B&uacute;squeda R&aacute;pida</td>
</tr>
<tr>
	<td>
		<input type="text" size="15" />
		<input type="button" value="Buscar" />
	</td>
</tr>
<tr>
	<td class="blocktitle">Filtrar por Precio</td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td class="blocktitle">Caracter&iacute;sticas</td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
</table>

</c:if>