<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/license.jsp" flush="true" />


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title><fmt:message key="login.title"  /></title>
	<jsp:include page="include/javascript.jsp" flush="true" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
	<script type="text/javascript" src="js/common.functions.js"></script>
	<script type="text/javascript">
		function afterLoad() {

			if ($('userName')) $('userName').focus();
		}

		

		function submitForm() {

			// remover mensajes y alertas
			$$('input.highlight').each(function(e) {
				e.removeClassName('highlight');
			});
			$$('img.highlight').each(function(e) {
				e.remove();
			});
			
			new Ajax.Request('profile.jspa?aid=processLogin',  {
				method: 'post',
				parameters: $('f_login').serialize(true),
				onComplete: function(transport) {
				 	response = transport.responseText.evalJSON();
					if (response.responseCode === 'success') {
						new Effect.Fade('d_msgs');
						alert('');
					} else if (response.responseCode === 'failure') 
						display_form_messages('d_msgs', response.errors, 'errors', true);
				},
				
				onFailure: function(transport) {
					alert('Error de Transporte');
				}
			});

			return false;
		}

		
	</script>
 </head>
 <body onload="afterLoad()">
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	<h1><fmt:message key="login.heading"  /></h1>
 	<fmt:message key="login.message" />
 	
 	<%--{{{ FORM : LOGIN FORM --%>
 	
 	<form id="f_login" onsubmit="return(submitForm())">
 	
	 	<div class="container bglight" style="width: 400px">
	 		<div id="d_msgs" style="display:none;"></div>		
			<table>
				
				
				<%--{{{ GROUP : CREDENTIALS INFORMACION --%>
				<tr>
					<td><label for="userName"><fmt:message key="login.userName" /></label></td>
					<td><label for="userPass"><fmt:message key="login.userPass" /></label></td>
				</tr>
				<tr>
					<td><input type="text" name="userName" id="userName" size="20" /></td>
					<td><input type="password" name="userPass" id="userPass" size="20" /></td>
				</tr>
				<%--}}} GROUP : CREDENTIALS INFORMACION --%>
				
				
				
			</table>
	
	 	</div>
	 	<br/>
	 	<input type="submit" value="Iniciar Sesi&oacute;n" />
 	</form>
 	<%--}}} FORM : LOGIN FORM --%>
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>
