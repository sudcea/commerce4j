<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/license.jsp" flush="true" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  
    <title></title>
	<jsp:include page="include/javascript.jsp" flush="true" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
	<script type="text/javascript" src="js/common.functions.js"></script>
	<script type="text/javascript">

		document.observe('dom:loaded', function()  {
			var lastIA = new C4JBlocks.LastAddedItems('last_added', 0, 3, 10);
			lastIA.start();			
			
		});
	</script>
 </head>
 <body>
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	<table width="100%">
 	<tr>
 	<td width="225" valign="top">
 		<jsp:include page="include/categories.jsp" flush="true" />
 	</td>
 	<td valign="top">
 		<div id="d_body">
			
			<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
			<td width="80%"> 			
 				<h3>&Uacute;ltimos Art&iacute;culos</h3>
 			</td>
 			</tr>
 			<tr>
 			<td colspan="2" valign="bottom">
 				<div id="last_added" class="container" style="height: 300px;" ></div>
 			</td>
 			</tr>
 			</table>
 			
 			
 		</div>
 	</td>
 	<td width="15%" valign="top">
 		<jsp:include page="include/featured.jsp" flush="true" />
 		<br/>
 		<jsp:include page="include/adsense.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 	
 	
 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>
