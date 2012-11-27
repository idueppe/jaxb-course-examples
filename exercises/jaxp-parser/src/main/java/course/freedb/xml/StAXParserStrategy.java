package course.freedb.xml;

import java.io.InputStream;

import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserStrategy;

public class StAXParserStrategy extends AbstractParserStrategy implements ParserStrategy {

	public void parseXMLDocument(ITrackList trackList) {
		if (trackList == null) {
			throw new IllegalArgumentException("SongList is not defined!");
		}

		InputStream inputStream = getXmlAsInputStream();

		// TODO Erstellen Sie einen XMLEventReader und übergeben Sie ihn dem StAXParser in der nächsten Zeile
		new StAXParser(trackList, null).parse(); // FIXME
	}
}
