<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${param.aid eq 'welcome' and user ne null}">
	<div class="container bglightyellow">
	
	<h2>Gracias por Registrarte!!!</h2>
	
	${user.firstName}, te damos la m&aacute;s cordial bienvenida a
	Commerce4J, gracias por registrarte, un correo electr&oacute;nico
	ha sido enviado a tu cuenta ${user.emailAddress}, es necesario
	que leas el correo y confirmes la cuenta para completar el proceso
	de registro.
</div>
</c:if>