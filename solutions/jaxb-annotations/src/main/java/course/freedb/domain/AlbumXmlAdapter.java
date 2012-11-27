package course.freedb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AlbumXmlAdapter extends XmlAdapter<Album,Album>{

	@Override
	public Album marshal(Album album) throws Exception {
		return album;
	}

	@Override
	public Album unmarshal(Album album) throws Exception {
		for(Track track: album.getTracks()) {
			track.setAlbum(album);
		}
		return album;
	}

}
