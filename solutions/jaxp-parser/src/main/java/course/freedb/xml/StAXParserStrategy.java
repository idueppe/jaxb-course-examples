package course.freedb.xml;

import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserStrategy;

public class StAXParserStrategy extends AbstractParserStrategy implements ParserStrategy {

	public void parseXMLDocument(ITrackList trackList) {
		if (trackList == null) {
			throw new IllegalArgumentException("SongList is not defined!");
		}

		InputStream inputStream = getXmlAsInputStream();

		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader reader = factory.createXMLEventReader(inputStream);

			new StAXParser(trackList, reader).parse();

		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
