<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



	<c:if test="${categories ne null}">
	<h3><strong>Explorar Categor&iacute;as</strong></h3>
	<table class="block">
	<tr><td>
	<div class="categories">
	
	<ul>
		<c:forEach items="${categories}" var="category">
		<li><a href="catalog.jspa?aid=browse&c=${category.categoryId}"><c:out value="${category.description}" escapeXml="true"/></a></li>
		</c:forEach>	
	</ul>
	
	</div>
	</td></tr>
	</table>
	</c:if>
	
	
	


