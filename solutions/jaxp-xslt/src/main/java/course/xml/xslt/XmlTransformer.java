package course.xml.xslt;

import java.io.InputStream;
import java.io.Writer;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * 
 * @author Ingo Dueppe
 */
public class XmlTransformer {

	public String asHtml(Writer writer, String xml, String xslt) {
		InputStream xmlIS = getResourceAsStream(xml);
		InputStream xslIS = getResourceAsStream(xslt);

		Source xslSource = new StreamSource(xslIS);
		Source xmlSource = new StreamSource(xmlIS);

		Result result = new StreamResult(writer);
		TransformerFactory factory = TransformerFactory.newInstance();
		
		try {
			Transformer transformer = factory.newTransformer(xslSource);
			transformer.transform(xmlSource, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	private InputStream getResourceAsStream(String xmlDocument) {
		return getClass().getClassLoader().getResourceAsStream(xmlDocument);
	}

}
