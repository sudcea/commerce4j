<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/jsp/include/license.jsp" flush="true" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  
    <title></title>
	<jsp:include page="/jsp/include/javascript.jsp" flush="true" />
	<script type="text/javascript" src="js/common.functions.js"></script>
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
 </head>
 <body>
 
 	<jsp:include page="/jsp/include/header.jsp" flush="true" />
 	

 	<h1>${item.itemTitle}</h1>

 	<table width="100%">
 	<tr>
 	<td valign="top">
 		<div id="d_body">
 			
 			
 			
 		</div>
 	</td>
 	</tr>
 	</table>

 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="/jsp/include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>
 	
 </body>
 </html>