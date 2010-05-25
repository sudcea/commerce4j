<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" encoding="UTF-8" />
	<xsl:template match="/">
		<html>
		<body>
		<xsl:apply-templates />
		</body>
		</html>
	</xsl:template>

	<xsl:template match="registration">
		<p>
		Bienvenido <xsl:value-of select="user/userName" />, este
		correo ha sido enviado a tu cuenta para completar el registro.
		</p>
		<p>
		Favor seguir el siguiente enlace para completar el registro
		<xsl:element name="a">
			<xsl:attribute name="href"><xsl:value-of select="url" /></xsl:attribute>
			<xsl:value-of select="url" />
		</xsl:element>
		</p>
		
		<p>
		Atte,<br/>
		<xsl:value-of select="store/storeName" /><br/>
		<xsl:element name="a">
			<xsl:attribute name="href"><xsl:value-of select="store/storeUrl" /></xsl:attribute>
			<xsl:value-of select="store/storeUrl" />
		</xsl:element>
		</p>
	</xsl:template>

</xsl:stylesheet> 