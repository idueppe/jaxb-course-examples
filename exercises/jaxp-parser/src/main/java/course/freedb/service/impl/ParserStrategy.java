package course.freedb.service.impl;

import course.freedb.service.ITrackList;

public interface ParserStrategy {

	public abstract void parseXMLDocument(ITrackList trackList);

}