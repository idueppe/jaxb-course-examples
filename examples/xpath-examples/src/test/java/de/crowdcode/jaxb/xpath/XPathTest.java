package de.crowdcode.jaxb.xpath;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.io.StringReader;


/**
 * @author idueppe
 * @since 1.0
 *        Date: 27.11.12
 *        Time: 08:55
 */
public class XPathTest {

    @Test
    public void testXPath() throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();

        String xml = "";

        InputStream is = getClass().getClassLoader().getResourceAsStream("cdliste.xml");


        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(is);

        Object result = xpath.evaluate("//titel", document, XPathConstants.NODESET);

        NodeList nodeList = (NodeList) result;

        for (int i = 0; i < nodeList.getLength(); i++) {
           Node node = nodeList.item(i);
            System.out.printf(node.toString());
        }
    }
}
