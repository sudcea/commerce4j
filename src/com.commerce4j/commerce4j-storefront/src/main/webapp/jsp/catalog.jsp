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
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
 </head>
 <body>
 
 	<jsp:include page="/jsp/include/header.jsp" flush="true" />
 	
 	<c:choose>
 		
 		<c:when test="${category ne null}">
 			<h1><c:out value="${category.description}" /></h1>
 		</c:when>
 		
 		<c:otherwise>
 			<h1>Explorar Cat&aacute;logo</h1>
 		</c:otherwise>
 	</c:choose>

 	<table width="100%">
 	<tr>
 	<td width="225" valign="top">
 		<jsp:include page="/jsp/include/categories.jsp" flush="true" />
 	</td>
 	<td valign="top">
 		<div id="d_body">
 		
 			<jsp:include page="include/listings.jsp">
 				<jsp:param value="table" name="table"/>
 			</jsp:include>
 		
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