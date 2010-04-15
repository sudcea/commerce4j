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
	<script type="text/javascript" src="js/livepipe.js"></script>
	<script type="text/javascript" src="js/scrollbar.js"></script>
	<script type="text/javascript">

		
		var offset = 1;
		var max = 3; 
	
		function afterLoad() {

			
			new PeriodicalExecuter(function() {
				last_added_items('last_added', offset, max);
				offset += max;
			}, 3);
			
		}
		
		function last_added_items(id ,first, max) {
			container = $(id);
			if (container) {
				// ajax controller call
				new Ajax.Request('catalog.jspa?aid=lastAddedItems',  {
					method: 'post',
					parameters : {first : first, max : max},
					onComplete: function(transport) {
					 	response = transport.responseText.evalJSON();
						if (response.responseCode === 'success') {
							
							listings = response.listings;
							table = new Element('table',{width: '100%', style : 'display:none;'});

							
							if ($A(listings).size() === 0) {
								offset = 0 ;
								return;
							} else {
								container.update('');
							}
							$A(listings).each(function(e) {
								
								tr = new Element('tr');
								
								// imagen
								td = new Element('td', {width: 100});
								img = new Element('img', {src : 'images/img_not_available.png'});
								td.insert(img);
								tr.insert(td);

								// item description
								td = new Element('td', {valign: 'top'});
								a = new Element('a', {
									href:'catalog.jspa?aid=detail&item='+e.itemId
								}).update(e.itemTitle);
								
								b = new Element('strong');
								b.insert(a);
								td.insert(b);
								td.insert(new Element('img', {
									src : 'images/new_transparent.gif'}
								));
								
								desc = new Element('div').update(e.itemDesc);
								desc.addClassName('gray smaller');
								td.insert(desc);
								tr.insert(td);

								// add row to table
								table.insert(tr);
							}); 
							Element.insert(container, table);
							new Effect.Appear(table);	
							
						}
						
					},
					
					onFailure: function(transport) {
						alert('Error de Transporte');
					}
				});
			}
		}

		document.observe('dom:loaded', afterLoad);
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
 				<div id="last_added" class="container" ></div>
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
