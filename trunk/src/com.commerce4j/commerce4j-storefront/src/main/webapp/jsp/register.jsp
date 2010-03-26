<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/license.jsp" flush="true" />


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title><fmt:message key="register.title"  /></title>
	<jsp:include page="include/javascript.jsp" flush="true" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
	<script type="text/javascript">
		function afterLoad() {
			/*
			var iso3country = '${iso3country}';
			if (iso3country) {
				$A($('country').options).each(function(opt) {
					if (opt.value === iso3country) 
						opt.selected = true;
				});
			}
			*/
		}


		function validate() {
			var isValid = true;

			return isValid;
		}
	</script>
 </head>
 <body onload="afterLoad()">
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	<h1><fmt:message key="register.heading"  /></h1>
 	Complete el siguiente formulario para registrarse como usuario y obtener
 	todos los beneficios 
 	
 	<form method="post" action="profile.jspa?aid=completeRegistration" onsubmit="return(validate())">
 	<div class="container bglight" style="width: 400px">		
		<table>

			<tr>
				<td colspan="2"><strong><fmt:message key="register.personalInfo" /></strong></td>
			</tr>
			<tr>
				<td><label for="firstName"><fmt:message key="register.firstname" /></label></td>
				<td><label for="lastName"><fmt:message key="register.lastname" /></label></td>
			</tr>
			<tr>
				<td><input type="text" name="firstName" id="firstname" size="20" /></td>
				<td><input type="text" name="lastName" id="lastName" size="20"/></td>
			</tr>
			<tr>
				<td><label for="stateOrProvince"><fmt:message key="register.country" /></label></td>
				<td><label for="stateOrProvince"><fmt:message key="register.stateOrProvince" /></label></td>
			</tr>
			<tr>
				<td>
					<select name="countryId" id="countryId">
						<c:forEach items="${countries}" var="country">
						<option value="${country.country_id}">${country.country_name}</option>
						</c:forEach>
					</select>
				</td>
				<td><input type="text" name="stateOrProvince" id="stateOrProvince" size="20"/></td>
			</tr>

			<tr>
				<td><label for="email"><fmt:message key="register.email" /></label></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" name="emailAddress" id="emailAddress" size="40"/>
					<div class="smaller gray">
					Su cuenta de correo ser&aacute; utilizada para confirmar la validez
					de su usuario.
					</div>
				</td>
			</tr>
			
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<tr>
				<td colspan="2"><strong><fmt:message key="register.credentialsInfo" /></strong></td>
			</tr>
			<tr>
				<td><label for="userName"><fmt:message key="register.username" /></label></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" name="userName" id="userName" size="20" />
					<input type="button" value="Verificar Disponibilidad" />
				</td>
			</tr>
			
			<tr>
				<td><label for="userPass"><fmt:message key="register.password" /></label></td>
				<td><label for="confirmPassword"><fmt:message key="register.confirmPassword" /></label></td>
			</tr>
			<tr>
				<td><input type="password" name="userPass" id="userPass" size="20" /></td>
				<td><input type="password" name="confirmUserPassword" id="confirmUserPassword" size="20"/></td>
			</tr>
			
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td colspan="2"><strong>&iquest;Acepta los terminos y condiciones de uso del sitio?</strong></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="checkbox" /> Si Acepto los terminos y condiciones de uso del sitio  </td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" /> Si Deseo recibir informaci&oacute;n en mi correo electro&oacute;nico</td>
			</tr>
			
		</table>

 	</div>
 	<br/>
 	<input type="submit" value="Registrarse" />
 	</form>
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>
