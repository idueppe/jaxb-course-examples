package course.freedb.xml;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import course.freedb.domain.Album;
import course.freedb.domain.Track;
import course.freedb.service.ITrackList;


/**
 * @author Ingo Düppe
 *
 */
public class SAXHandler extends DefaultHandler  {

	private ITrackList trackList;

	private StringBuilder nodeValue;
    private Track currentTrack;
    private Album currentAlbum;
    
    private Stack<ElementType> elementStack;
    
    public SAXHandler() {
        elementStack = new Stack<ElementType>();
        nodeValue = new StringBuilder();
    }


    /**
     * SAX callback: 
     * Diese Method wird während des XML-Parsing gerufen, sobald ein Bündel von Zeichen geparset wurden.
     * Es ist nicht Garantiert, dass der Parser eine bestimmte Information in einem Bündel von Zeichen meldet.
     * 
     * Daher müssen alle Zeichenbündel gesammelt werden, bis das Ende des aktuellen Elements erreicht wurde.
     */
    public void characters(char[] ch, int start, int length) {
    	nodeValue.append(ch, start, length);
    }

    /**
     * SAX callback: Diese Methode wird vom Parser am Ende jedes Elements gerufen.
     * An dieser Stelle wird die Information in das jeweilige Domain-Objekt (bspw. currentAlbum) 
     * eingetragen.
     */
    public void endElement(String url, String localName, String qName) {
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
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String name = qName;
        
        ElementType currentElement = ElementType.valueOf(name.toUpperCase());
        if (currentElement == null) {
        	currentElement = ElementType.UNKOWN;
        }
        
        elementStack.push(currentElement);
        
        if (currentElement == ElementType.ALBUM) {
        	currentAlbum = new Album();
        } else if (currentElement == ElementType.TRACK) {
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

