package de.crowdcode.jaxb.xpath;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;


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

        InputStream is = getClass().getClassLoader().getResourceAsStream("cdliste.xml");


        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(is);

        Node node = (Node) xpath.evaluate("/child::cdliste/child::cd[4]", document, XPathConstants.NODE);
        System.out.println(node.getNodeName());//+" "+node.getTextContent());
        
//        NodeList nodeList = (NodeList) xpath.evaluate("titel/following-sibling::track", node, XPathConstants.NODESET);
        NodeList nodeList = (NodeList) xpath.evaluate("//cd[@jahr<=1997]/@jahr", document, XPathConstants.NODESET);
//        NodeList nodeList = (NodeList) xpath.evaluate("//cd[@name='xyz']", document, XPathConstants.NODESET);
        
        printNodeList(nodeList, 0);
    }

    private void printNodeList(NodeList nodeList, int indent) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Text) {
                System.out.println(indent(indent)+" "+node.getTextContent());
            } else {
                System.out.println(indent(indent) + " |" + node.getNodeName() + "|");
            }
            printNodeList(node.getChildNodes(), indent + 1);
        }
    }

    private String indent(int indent) {
        return StringUtils.repeat("\t", indent);
    }
}
