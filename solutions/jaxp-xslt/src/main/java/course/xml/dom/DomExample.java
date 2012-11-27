package course.xml.dom;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Ingo Dueppe
 */
public class DomExample {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("cdliste.xml");
		Document document = builder.parse(is);
		NodeList nodes = document.getChildNodes();
		traverse(nodes);
	}

	private static void traverse(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			printCDTitel(node);
			traverse(node.getChildNodes());
		}
	}

	private static void printCDTitel(Node node) {
		if ("titel".equals(node.getNodeName()) && "cd".equals(node.getParentNode().getNodeName())) {
			System.out.println("CD: " + node.getTextContent());
		}
	}

}
