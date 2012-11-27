package course.freedb.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import course.freedb.domain.Album;
import course.freedb.domain.Track;
import course.freedb.service.ITrackList;

public class DOMTrackParser {
	
	private ITrackList trackList;
	private Document document;
	
	private Album currentAlbum;

	public DOMTrackParser(ITrackList trackList, Document document) {
		this.trackList = trackList;
		this.document = document;
	}

	public void parse() {
		Element element = document.getDocumentElement();
		System.out.println(element);
		NodeList nodeList = element.getChildNodes();
		parse(nodeList);
		
//		parse(document.getChildNodes());
	}

	private void parse(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Element element = (Element) node;
				ElementType type = ElementType.valueOf(element.getNodeName().toUpperCase());
				switch (type) {
					case ALBUM:
						parseAlbum(element);
						parse(element.getChildNodes());
						break;
					case TRACK:
						parseTrack(element);
						break;
					default:
						parse(element.getChildNodes());
						break;
				}
			}
		}
	}
	
	private void parseAlbum(Element album) {
		currentAlbum = new Album();
		
		Element discid = (Element) album.getElementsByTagName("discid").item(0);
		currentAlbum.setDiscId(discid.getTextContent());
		Element artist = (Element) album.getElementsByTagName("artist").item(0);
		currentAlbum.setArtist(artist.getTextContent());
		Element name = (Element) album.getElementsByTagName("name").item(0);
		currentAlbum.setName(name.getTextContent());
		Element genre = (Element) album.getElementsByTagName("genre").item(0);
		currentAlbum.setGenre(genre.getTextContent());

		try {
			Element year = (Element) album.getElementsByTagName("year").item(0);
			currentAlbum.setYear(Integer.valueOf(year.getTextContent()));
		} catch (NumberFormatException ex) {
			// Nothing
		}
	
	}

	private void parseTrack(Element element) {
		Track track = new Track(currentAlbum);
		Element trackno = (Element) element.getElementsByTagName("trackno").item(0);
		track.setTrackNo(Integer.valueOf(trackno.getTextContent()));
		Element title = (Element) element.getElementsByTagName("title").item(0);
		track.setTitle(title.getTextContent());
		trackList.appendTrack(track);
	}
	

}
