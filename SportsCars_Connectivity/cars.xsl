<?xml version="1.0" encoding="UTF-8"?>
<!-- xsl stylesheet declaration with xsl namespace: elements with xsl: prefix are used for xlst processing -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  

<!-- xsl template declaration: template used for formatting - matching document root element. It takes an XPath expression. -->
<xsl:template match="/">

<!-- HTML tags: XSLT processor will skip them and browser will simply render them. -->
  <html>
  <head>
  <style>
    table, th, td {
      border: 1px solid black;
    }
  </style>
  </head>
  <body>
  <h2>SportCars</h2>
  <table>
    <tr style="background:#B0C4DE">
	  <th>Year</th>
      <th>Make</th>
      <th>Model</th>
	  <th>Price</th>
    </tr>
	
	<!-- for-each processing instruction - looking for each element matching the XPAth expression -->
    <xsl:for-each select="CARS/CAR">
    <tr>
      <td><xsl:value-of select="YEAR"/></td>
      <td><xsl:value-of select="MAKE"/></td>
	  <td><xsl:value-of select="MODEL"/></td>
	  <td><xsl:value-of select="PRICE"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
