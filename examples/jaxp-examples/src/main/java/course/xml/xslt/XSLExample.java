package course.xml.xslt;

import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * 
 * @author Ingo Dueppe
 */
public class XSLExample {

	public static void main(String[] args) throws Exception {
		InputStream xmlIS = getResourceAsStream("cdliste.xml");
		InputStream xslIS = getResourceAsStream("cdliste.xslt");

		Source xslSource = new StreamSource(xslIS);
		Source xmlSource = new StreamSource(xmlIS);

		Result result = new StreamResult(System.out);

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(xslSource);

		transformer.transform(xmlSource, result);
	}

	private static InputStream getResourceAsStream(String xmlDocument) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlDocument);
	}

}
