package course.xml.xslt;

import java.io.PrintWriter;

import org.junit.Test;


public class TestTransformer {
	
	@Test
	public void testCDListe() {
		XmlTransformer transformer = new XmlTransformer();
		transformer.asHtml(new PrintWriter(System.out),"cdliste.xml","cdliste.xslt");
	}
	
	@Test
	public void testttElements() {
		XmlTransformer transformer = new XmlTransformer();
		transformer.asHtml(new PrintWriter(System.out),"elements.xml","elements.xslt");
	}

}
