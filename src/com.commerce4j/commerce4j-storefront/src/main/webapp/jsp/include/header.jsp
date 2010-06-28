<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<table width="100%">
<tr>
<td><img src="images/img_logo_header.png" alt="" /></td>
<td valign="bottom" width="80%">
	<span class="smaller gray">
		Bienvenido!!!, 
		
		<a href="profile.jspa?aid=login">Iniciar Sesi&oacute;n</a> 
		&oacute; 
		
		<a href="profile.jspa?aid=register">Registrarse</a>

                <a href="home.jspa?aid=help"> Ayuda</a>
	</span>
</td>
<td align="right" width="20%" valign="bottom">
	
	
	<table cellpadding="0" cellspacing="0">
	<tr>
	<td class="smaller gray"><a href="home.jspa">Inicio</a></td>
	<td class="smaller gray">|</td>
        <td class="smaller gray"><a href="profile.jspa?aid=profile"><fmt:message key="profile.link" /></a></td>
	<td class="smaller gray">|</td>
	<td class="smaller gray"><a href="cart.jspa"><img src="images/cart.png" alt="" /></a></td>
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
	<a href="javascript:void(0)" onclick="show_category_bubble(this)"><fmt:message key="storefront.catalog.link" /></a> |
	<a href="help.jspa"><fmt:message key="storefront.help.link" /></a>
</td>
<td align="right">
<div class="navsearch">
<input type="text" size="50" /><input type="button" value="Buscar" />
</div>
</td>
</tr>
</table>
	
</div> 



<div id="category_bubble" class="bubble" style="display:none">
<h4>Cat&aacute;logo y Categor&iacute;as</h4>
</div>
