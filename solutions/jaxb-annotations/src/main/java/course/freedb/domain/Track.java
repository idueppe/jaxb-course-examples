package course.freedb.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <p>Überschrift: Music DB - Client</p>
 * @author Ingo Düppe
 * @version 1.0
 */
@XmlType(
		name="TrackType",
		namespace="http://www.dueppe.com/course/dictionary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Track implements Serializable{

	private static final long serialVersionUID = 2942731592229151236L;
    
	@XmlElement(required=true)
    private String title;
	
	@XmlTransient
    private Album album;
	
    @XmlElement(required=true)
    private int trackNo;

    public Track() { }
    
    public Track(Album album) {
        this.album = album;
    }
    
    public Album getAlbum() {
        return album;
    }
    
    public void setAlbum(Album album) {
    	this.album = album;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getTrackNo() {
        return trackNo;
    }
    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + trackNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trackNo != other.trackNo)
			return false;
		return true;
	}
    
    @Override
    public String toString() {
    	return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE).append(trackNo).append(title).toString();
    }

}
