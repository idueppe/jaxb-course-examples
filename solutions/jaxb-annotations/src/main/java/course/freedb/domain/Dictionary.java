package course.freedb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace="http://www.dueppe.com/course/dictionary")
@XmlType(name="DictionaryType", 
		namespace="http://www.dueppe.com/course/dictionary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dictionary {
	
	@XmlElement(name="album", namespace="http://www.dueppe.com/course/dictionary")
	private List<Album> albums = new ArrayList<Album>();

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	

}
