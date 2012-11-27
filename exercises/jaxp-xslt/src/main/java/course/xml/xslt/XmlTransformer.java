package course.xml.xslt;

import java.io.InputStream;
import java.io.Writer;

/**
 * 
 * @author Ingo Dueppe
 */
public class XmlTransformer {

	public String asHtml(Writer writer, String xml, String xslt) {
		// TODO Transformieren Sie bitte das XML Dokument mit dem XSLT und geben Sie das Ergebnis als String zurück

		return "FIXME :-)";
	}

	private InputStream getResourceAsStream(String xmlDocument) {
		return getClass().getClassLoader().getResourceAsStream(xmlDocument);
	}

}
