package course.freedb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author Ingo Dueppe
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
		name="AlbumType",
		namespace="http://www.dueppe.com/course/dictionary",
		propOrder={"discId","artist","name", "genre", "year", "tracks"})
@XmlJavaTypeAdapter(AlbumXmlAdapter.class)
public class Album {

	@XmlElement(required=true)
	private String name;

	@XmlElement(required=true)
	private String discId;

	@XmlElement(required=true)
	private String genre;
	
	@XmlElement(required=true)
	private String artist;
	
	@XmlElement(required=true)
	private int year;
	
	@XmlElement(name="track",
			namespace="http://www.dueppe.com/course/dictionary",
			required=true,
			nillable=false)
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDiscId() {
		return discId;
	}

	public void setDiscId(String discID) {
		this.discId = discID;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
		.append(discId)
		.append(name)
		.append(artist)
		.append(genre)
		.append(year)
		.toString();
	}
}
