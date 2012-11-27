package course.freedb.xml;

import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserStrategy;

public class SAXParserStrategy extends AbstractParserStrategy implements ParserStrategy {

	public void parseXMLDocument(ITrackList trackList) {
		if (trackList == null) {
		    throw new IllegalArgumentException("SongList is not defined!");
		}
		try {
		    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		    parserFactory.setValidating(false);
		    parserFactory.setNamespaceAware(false);

		    SAXParser parser = parserFactory.newSAXParser();

		    SAXHandler handler = new SAXHandler();
		    handler.setTrackList(trackList);

		    InputSource inputSource = getXmlAsInputSource();
		    parser.parse(inputSource, handler);
		} catch (IOException exception) {
		    exception.printStackTrace();
		} catch (SAXException exception) {
		    exception.printStackTrace();
		} catch (ParserConfigurationException exception) {
		    exception.printStackTrace();
		} catch (FactoryConfigurationError exception) {
		    exception.printStackTrace();
		}
	}
}
