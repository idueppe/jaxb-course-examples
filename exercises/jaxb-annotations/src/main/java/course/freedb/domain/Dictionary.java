package course.freedb.domain;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	private List<Album> albums = new ArrayList<Album>();

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	

}
