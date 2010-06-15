<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/license.jsp" flush="true" />


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title><fmt:message key="profile.title"  /></title>
	<jsp:include page="include/javascript.jsp" flush="true" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
	<script type="text/javascript" src="js/common.functions.js"></script>
	<script type="text/javascript" src="js/profile.functions.js"></script>
	<script type="text/javascript">
		function afterLoad() {


		}

	</script>
 </head>
 <body onload="afterLoad()">

 	<jsp:include page="include/header.jsp" flush="true" />

 	<h1><fmt:message key="profile.heading"  /></h1>
 	<fmt:message key="profile.message" />


 	

 	<table width="100%">
 	<tr>
 	<td valign="top">
 	<jsp:include page="include/footer.jsp" flush="true" />
 	</td>
 	</tr>
 	</table>

 </body>
 </html>
