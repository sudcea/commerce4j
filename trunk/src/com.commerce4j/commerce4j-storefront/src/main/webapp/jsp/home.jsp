<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/license.jsp" flush="true" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  
    <title><fmt:message key="home.title"  /></title>
	<jsp:include page="include/javascript.jsp" flush="true" />
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
	<script type="text/javascript" src="js/common.functions.js"></script>
	<script type="text/javascript">

		document.observe('dom:loaded', function()  {
			var uri = 'syndication.jspa?aid=findLastAddedItems';
			var block_last_added = new C4JBlocks.ItemRotator(
				uri,'d_lastadded', {
				max: 3, duration: 10
			}).start();	

			var block_featured = new C4JBlocks.ItemRotator(
				uri,'d_featured', {
				max: 3, orientation: 'v',duration: 25
			}).start();	

			uri = 'syndication.jspa?aid=countAllTagsByName';
			var block_tagcloud = new C4JBlocks.TagCloud(
				uri,'d_tagcloud'
			).display();
					
		});
	</script>
 </head>
 <body>
 
 	<jsp:include page="include/header.jsp" flush="true" />
 	
 	<table width="100%">
 	<tr>
 	<td width="225" valign="top">
 		<jsp:include page="include/categories.jsp" flush="true" />
 		<jsp:include page="include/tagcloud.jsp" flush="true" />
 	</td>
 	<td valign="top">
 		<div id="d_body">
 		
 			
 			<jsp:include page="include/welcome.jsp" flush="true" />
 			
			
			<table width="100%">
			<tr>
			<td valign="top">
				<div id="carrousel">
				<img src="images/carrousel-banner-1.jpg" />
				</div>
			</td>
			<td valign="top">
				
			</td>
			</tr>
			</table>
			
			
			
			<div class="container bglightyellow">
				<img src="images/error.png" />
				<fmt:message key="home.message"  />
			</div>
			
			<jsp:include page="include/lastadded.jsp" flush="true" />
 			
 			
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
