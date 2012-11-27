package course.freedb.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserStrategy;

public class DOMParserStrategy extends AbstractParserStrategy implements ParserStrategy {

	public void parseXMLDocument(ITrackList trackList) {
		if (trackList == null) {
		    throw new IllegalArgumentException("SongList is not defined!");
		}
		
			InputSource inputSource = getXmlAsInputSource();

			// TODO Erstellen Sie einen DocumentBuilder und lesen Sie das XML-Document ein
			
			Document document = null; // FIXME
			
			new DOMTrackParser(trackList, document).parse();
			
	}
}
