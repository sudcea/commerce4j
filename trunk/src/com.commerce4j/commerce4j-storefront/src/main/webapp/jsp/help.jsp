<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <head>
    <title><fmt:message key="storefront.help.link"/></title>
	<c:if test="${help ne null}">
	<h3><strong>Preguntas m&aacute;s frecuentes</strong></h3>
	<table class="block">
	<tr><td>
	<div class="categories">

	<ul>
		<c:forEach items="${help}" var="helps">
                    <li><a href="#${helps.question_id}"><c:out value="${helps.question}" escapeXml="true"/></a></li>
                   <c:out value="${helps.question_description}"/>
		</c:forEach>
	</ul>

	</div>
	</td></tr>
	</table>
	<br/>
	</c:if>





