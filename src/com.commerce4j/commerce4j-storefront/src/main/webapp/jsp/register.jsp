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
	<script type="text/javascript" src="js/common.functions.js"></script>
	<script type="text/javascript" src="js/profile.functions.js"></script>
	<script type="text/javascript">
		function afterLoad() {

			if ($('firstName')) $('firstName').focus();
		}

	</script>
 </head>
 <body onload="afterLoad()">
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	<h1><fmt:message key="register.heading"  /></h1>
 	<fmt:message key="register.message" />
 	
 	<%--{{{ FORM : REGISTRATION FORM --%>
 	
 	<form id="f_registration" onsubmit="register_user();return(false);">
 	
	 	<div class="container bglight" style="width: 400px">
	 		<div id="d_msgs" style="display:none;"></div>		
			<table>
				<%--{{{ GROUP : PERSONAL INFORMACION --%>
				<tr>
					<td colspan="2">
						<strong><fmt:message key="register.personalInfo" /></strong>
					</td>
				</tr>
				
				<%--{{{ FULLNAME, firstname and lastname --%>
				<tr>
					<td><label for="firstName"><fmt:message key="register.firstName" /></label></td>
					<td><label for="lastName"><fmt:message key="register.lastName" /></label></td>
				</tr>
				<tr>
					<td><input type="text" name="firstName" id="firstName" size="20" /></td>
					<td><input type="text" name="lastName" id="lastName" size="20"/></td>
				</tr>
				<%--}}} FULLNAME, firstname and lastname --%>
				
				
				<%--{{{ COUNTRY and STATE --%>
				<tr>
					<td><label for="stateOrProvince"><fmt:message key="register.countryId" /></label></td>
					<td><label for="stateOrProvince"><fmt:message key="register.stateOrProvince" /></label></td>
				</tr>
				<tr>
					<td>
						<select name="countryId" id="countryId">
							<option value="">- Seleccione un Pa&iacute;s -</option>
							<c:forEach items="${countries}" var="country">
								<option value="${country.country_id}">${country.country_name}</option>
							</c:forEach>
						</select>
					</td>
					<td><input type="text" name="stateOrProvince" id="stateOrProvince" size="20"/></td>
				</tr>
				<%--}}} COUNTRY and STATE --%>
	
				<%--{{{ EMAIL ADDRESS --%>
				<tr>
					<td><label for="email"><fmt:message key="register.emailAddress" /></label></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="emailAddress" id="emailAddress" size="40"/>
						<div class="smaller gray">
							<fmt:message key="register.emailInfo" />
						</div>
					</td>
				</tr>
				<%--}}} EMAIL ADDRESS --%>
				
				
				<%--{{{ PHONE NUMBER --%>
				<tr>
					<td><label for="cellPhone"><fmt:message key="register.cellPhone" /></label></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="cellPhone" id="cellPhone" size="20"/>
					</td>
				</tr>
				
				
				<%--}}} GROUP : PERSONAL INFORMACION --%>
				
				<tr><td colspan="2">&nbsp;</td></tr>
				
				
				
				<%--{{{ GROUP : CREDENTIALS INFORMACION --%>
				<tr>
					<td colspan="2">
						<strong><fmt:message key="register.credentialsInfo" /></strong>
					</td>
				</tr>
				<tr>
					<td><label for="userName"><fmt:message key="register.userName" /></label></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="userName" id="userName" size="20" />
						<input type="button" value="Verificar Disponibilidad" />
					</td>
				</tr>
				
				<tr>
					<td><label for="userPass"><fmt:message key="register.userPass" /></label></td>
					<td><label for="confirmPassword"><fmt:message key="register.confirmPassword" /></label></td>
				</tr>
				<tr>
					<td><input type="password" name="userPass" id="userPass" size="20" /></td>
					<td><input type="password" name="confirmPassword" id="confirmPassword" size="20"/></td>
				</tr>
				<%--}}} GROUP : CREDENTIALS INFORMACION --%>
				
				<tr><td colspan="2">&nbsp;</td></tr>
				
				<%--{{{ GROUP : TERM AND CONDITIONS POLICY --%>
				<tr>
					<td colspan="2"><strong><fmt:message key="register.acceptTermAndConditions"/></strong></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<table>
						<tr>
						<td valign="top"><input type="checkbox" name="acceptTermAndConditions" id="acceptTermAndConditions" value="true"/></td>
						<td valign="top">
						<label for="acceptTermAndConditions">
							<fmt:message key="register.acceptTermAndConditions"/>
						</label>
						</td>
						</tr>
						</table>
						
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table>
						<tr>
						<td valign="top"><input type="checkbox" name="acceptMailConditions" id="acceptMailConditions" /></td>
						<td valign="top">
						<label for="acceptMailConditions">
							<fmt:message key="register.acceptMailConditions" />
						</label>
						</td>
						</tr>
						</table>
					</td>
				</tr>
				<%--}}} GROUP : TERM AND CONDITIONS POLICY --%>
				
			</table>
	
	 	</div>
	 	<br/>
	 	<input type="submit" value="Registrarse" />
 	</form>
 	<%--}}} FORM : REGISTRATION FORM --%>
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>
