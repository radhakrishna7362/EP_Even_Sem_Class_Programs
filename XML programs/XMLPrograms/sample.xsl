<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Students Information</h2>
				<table border="1" style="border-collapse:collapse;padding:10px;">
					<tr bgcolor="#9acd32">
						<th>Name</th>
						<th>Dept</th>
					</tr>
					<xsl:for-each select="class/student">
						<tr>
							<td><xsl:value-of select="name"></xsl:value-of></td>
							<td><xsl:value-of select="dept"></xsl:value-of></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>