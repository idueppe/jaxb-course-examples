<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
	<xsl:output indent="yes" method="html"/>
	<xsl:template match="/">
		<html>
			<body>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="PERIODIC_TABLE">
		<h1>Das Periodensystem der Elemente</h1>
		<table border="1">
			<tbody>
				<tr>
					<th>Name</th>
					<th>Gewicht</th>
					<th>Nummer</th>
					<th>Dichte</th>
				</tr>
				<xsl:apply-templates select="ATOM"/>
			</tbody>
		</table>
	</xsl:template>
	<xsl:template match="ATOM">
		<tr bgcolor="{if (position() mod 2 = 0) then 'green' else 'white'}">
			<td>
				<xsl:value-of select="NAME"/>
			</td>
			<td>
				<xsl:value-of select="ATOMIC_WEIGHT"/>
			</td>
			<td>
				<xsl:value-of select="ATOMIC_NUMBER"/>
			</td>
			<td>
				<xsl:value-of select="if (DENSITY) then normalize-space(DENSITY) else 'n.z.'"/>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
