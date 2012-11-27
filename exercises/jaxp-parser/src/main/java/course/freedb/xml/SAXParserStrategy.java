package course.freedb.xml;

import org.xml.sax.InputSource;

import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserStrategy;

public class SAXParserStrategy extends AbstractParserStrategy implements ParserStrategy {

	public void parseXMLDocument(ITrackList trackList) {
		if (trackList == null) {
		    throw new IllegalArgumentException("SongList is not defined!");
		}
		InputSource inputSource = getXmlAsInputSource();

		// TODO Erstellen Sie SAX Parser

		SAXHandler handler = new SAXHandler();
		handler.setTrackList(trackList);
		
		// TODO Parsen Sie das XML-Document mittels des SAX Parsers und dem SAXHandler
	}
}
