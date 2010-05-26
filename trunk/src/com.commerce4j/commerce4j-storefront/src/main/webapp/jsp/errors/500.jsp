<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/jsp/include/license.jsp" flush="true" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
               "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  
    <title>Error Interno de Servidor</title>
	<link rel="stylesheet" type="text/css" href="css/screen.css" />
 </head>
 <body>


<h1>Error 500, Error Interno de Servidor</h1>

	<%-- Exception Handler --%>
	<font color="red">
	<%= exception.toString() %><br>
	</font>

	<%
	out.println("<!--");
	java.io.StringWriter sw = new java.io.StringWriter();
	java.io.PrintWriter pw = new java.io.PrintWriter(sw);
	exception.printStackTrace(pw);
	out.print(sw);
	sw.close();
	pw.close();
	out.println("-->");
	%>

</body>
</html>