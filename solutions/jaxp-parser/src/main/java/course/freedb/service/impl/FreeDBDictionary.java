package course.freedb.service.impl;

import course.freedb.service.IFreeDBDictionary;
import course.freedb.service.ITrackFilter;
import course.freedb.service.ITrackList;


/**
 * @author Ingo Düppe
 * @version 1.0
 */
public class FreeDBDictionary implements IFreeDBDictionary {

	private ParserStrategy parserStrategy;

    public FreeDBDictionary(ParserStrategy parserStrategy) {
    	this.parserStrategy = parserStrategy;
    }

    public ITrackList findTracks(ITrackFilter filter) {
        ITrackList trackList = new TrackList(filter);
        parserStrategy.parseXMLDocument(trackList);
        return trackList;
    }

}