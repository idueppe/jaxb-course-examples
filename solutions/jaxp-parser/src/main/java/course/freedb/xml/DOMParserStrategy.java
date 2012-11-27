package course.freedb.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserStrategy;

public class DOMParserStrategy extends AbstractParserStrategy implements ParserStrategy {

	public void parseXMLDocument(ITrackList trackList) {
		if (trackList == null) {
		    throw new IllegalArgumentException("SongList is not defined!");
		}
		
		try {
			
			InputSource inputSource = getXmlAsInputSource();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(inputSource);
			
			new DOMTrackParser(trackList, document).parse();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
