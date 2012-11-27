<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" use-character-maps="mymap"></xsl:output>
	<xsl:character-map name="mymap">
		<xsl:output-character character="€" string="&amp;euro; zzgl. USt."/>
	</xsl:character-map>
	<xsl:template match="/">
		<html>
			<body>
				<xsl:apply-templates select="cdliste"/>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="cdliste">
		<h1>
			<xsl:value-of select="listentitel"/>
		</h1>
		<xsl:value-of select="erstelldatum"/>
		<p/>
		<xsl:value-of select="beschreibung"/>
		<p/>
		<xsl:apply-templates select="cd"/>
	</xsl:template>
	<xsl:template match="cd">
		<p></p>
		<table border="1" width="50%">
			<tr><th><xsl:value-of select="interpret"/>: <xsl:value-of select="titel"/></th></tr>
			<xsl:variable name="preis" select="preis"/>
			<tr><td>
				<xsl:if test="$preis &lt; 20">
					<xsl:attribute name="bgcolor">yellow</xsl:attribute>
				</xsl:if>
			<xsl:value-of select="$preis"/> €</td></tr>
			<tr><td><xsl:value-of select="hersteller"/></td></tr>
			<tr><td><ul><xsl:apply-templates select="track"/></ul></td></tr>
		</table>
	</xsl:template>
	<xsl:template match="track">
		<li><xsl:value-of select="titel"/></li>
	</xsl:template>
</xsl:stylesheet>
