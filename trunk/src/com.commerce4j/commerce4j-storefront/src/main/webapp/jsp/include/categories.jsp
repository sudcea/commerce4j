<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



	<c:forEach items="${categories}" var="category">
	<div class="categories">
	<ul>
		<li><a href="catalog.jspa?aid=browse&c=${category.categoryId}"><c:out value="${category.description}" escapeXml="true"/></a></li>
	</ul>	
	</div>
	</c:forEach>
	
	<table width="100%">
	<tr>
	<td align="right" ><div class="smaller">[<a href="catalogo.jsp?aid=all">Ver Todas</a>]</div></td>
	</tr>
	</table>


