<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<table width="100%">
<tr>
<td><img src="http://code.google.com/p/commerce4j/logo?logo_id=1269574971" alt="" /></td>
<td valign="bottom" width="80%">
	<span class="smaller gray">
		Bienvenido!!!, 
		
		<a href="profile.jspa?aid=login">Iniciar Sesi&oacute;n</a> 
		&oacute; 
		
		<a href="profile.jspa?aid=register">Registrarse</a>
	</span>
</td>
<td align="right" width="20%" valign="bottom">
	
	
	<table cellpadding="0" cellspacing="0">
	<tr>
	<td class="smaller gray"><a href="home.jspa">Inicio</a></td>
	<td class="smaller gray">|</td>
	<td class="smaller gray"><a href="cart.jspa"><img src="images/cart.png" /></a></td>
	<td class="smaller gray"><a href="cart.jspa">Carrito</a></td>
	</tr>
	</table>
	
	
</td>

</tr>
</table>

<div id="d_navbar" class="navlinks">
<table width="100%">
<tr>
<td>
	<a href="home.jspa"><fmt:message key="storefront.home.link" /></a> |
	<a href="catalog.jspa"><fmt:message key="storefront.catalog.link" /></a> |
	<a href="help.jspa"><fmt:message key="storefront.help.link" /></a>
</td>
</tr>
</table>
	
</div> 

<div class="navsearch">
<input type="text" size="50" /><input type="button" value="Buscar" />
</div>