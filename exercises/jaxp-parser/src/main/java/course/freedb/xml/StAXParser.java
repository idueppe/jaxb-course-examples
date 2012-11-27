package course.freedb.xml;

import java.util.Stack;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import course.freedb.domain.Album;
import course.freedb.domain.Track;
import course.freedb.service.ITrackList;

public class StAXParser {

	private ITrackList trackList;
	private XMLEventReader reader;
	
	private Stack<ElementType> elementStack;
	private StringBuilder nodeValue;
	
	private Album currentAlbum;
	private Track currentTrack;

	public StAXParser(ITrackList trackList, XMLEventReader reader) {
		elementStack = new Stack<ElementType>();
	    nodeValue = new StringBuilder();
		
		this.trackList = trackList;
		this.reader = reader;
	}

	public void parse() {
		// TODO Parsen Sie das Dokument mittels des XMLEventReader
		// TODO Beachten Sie dabei die Hilfsmethoden
	}

	private ElementType toElementType(StartElement start) {
		return ElementType.valueOf(start.getName().toString().toUpperCase());
	}

    /**
     * SAX callback: Diese Methode wird vom Parser am Ende jedes Elements gerufen.
     * An dieser Stelle wird die Information in das jeweilige Domain-Objekt (bspw. currentAlbum) 
     * eingetragen.
     */
    public void endElement() {
    	String nodeValue = this.nodeValue.toString().trim();
        switch (elementStack.pop()) {
        	case ALBUM:
        	    currentAlbum = null;
        	    currentTrack = null;
        	    break;
            case DISCID:
                currentAlbum.setDiscId(nodeValue);
                break;
            case ARTIST:
                currentAlbum.setArtist(nodeValue);
                break;
            case NAME:
                currentAlbum.setName(nodeValue);
                break;
            case GENRE:
                currentAlbum.setGenre(nodeValue);
                break;
            case YEAR:
                try {
                    currentAlbum.setYear(Integer.parseInt(nodeValue));
                } catch (NumberFormatException ex) {}
                break;
        	case TRACK:
                addTrack(currentTrack);
                currentTrack = null;
                break;
            case TRACKNO:
                try {
                    currentTrack.setTrackNo(Integer.parseInt(nodeValue));
                } catch (NumberFormatException ex) {}
                break;
        	case TITLE:
                currentTrack.setTitle(nodeValue);
                break;
            default:
                break;
        }
        this.nodeValue.setLength(0);
    }

    /**
     * SAX callback: 
     * 
     * SAX callback: Diese Methode wird vom Parser am Anfang jedes Elements gerufen.
     * An dieser Stelle wird die Information in das jeweilige Domain-Objekt (bspw. currentAlbum) 
     * eingetragen.
     * 
     * called by the parser at the beginning of each element.
     * Here we push the type of the node in a stack, so we can retrieve the information
     * when the element has been parsed.
     */
    public void startElement(ElementType element) {
        elementStack.push(element);
        
        if (element == ElementType.ALBUM) {
        	currentAlbum = new Album();
        } else if (element == ElementType.TRACK) {
        	currentTrack = new Track(currentAlbum);
        }
    }

    public void setTrackList(ITrackList trackList) {
    	this.trackList = trackList;
    }
    
    public void addTrack(Track track) {
    	if (trackList != null){
    		trackList.appendTrack(track);
    	}
    } 	
	
}
