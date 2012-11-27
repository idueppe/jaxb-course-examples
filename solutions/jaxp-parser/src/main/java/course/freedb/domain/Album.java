package course.freedb.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ingo Dueppe
 */
public class Album {

	private String discId;
	private String name;
	private String artist;
	private String genre;
	private int year;

	public Album() {

	}

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
