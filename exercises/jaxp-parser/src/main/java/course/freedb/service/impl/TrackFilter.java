package course.freedb.service.impl;

import org.apache.commons.lang.StringUtils;

import course.freedb.domain.Track;
import course.freedb.service.ITrackFilter;

/**
 * Überschrift: Music DB - Client
 * @author Ingo Düppe
 * @version 1.0
 */
public class TrackFilter implements ITrackFilter {
    private String title;
    private String artist;
    private String genre;
    private String album;

    private String name;

    public TrackFilter(String title, String artist, String album, String genre) {
        this.artist = (artist == null || "".equals(artist)) ? null : artist.trim();
        this.title = (title == null || "".equals(title)) ? null : title.trim();
        this.album = (album == null || "".equals(album)) ? null : album.trim();
        this.genre = (genre == null || "".equals(genre)) ? null : genre.trim();

        name = "(" + title + "," + artist + "," + album + "," + genre + ")";

    }

    /**
	 * {@inheritDoc}
	 */
    public boolean matches(Track track) {
        boolean matches = true;
        matches &= ((artist == null) || track.getAlbum().getArtist().equalsIgnoreCase(artist));
        matches &= ((genre == null) || track.getAlbum().getGenre().equalsIgnoreCase(genre));
        matches &= ((album == null) || track.getAlbum().getName().equalsIgnoreCase(album));
        matches &= ((title == null) || track.getTitle().equalsIgnoreCase(title));

        return matches;
    }

    /**
	 * {@inheritDoc}
	 */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TrackFilter) {
            TrackFilter filter = (TrackFilter) obj;
            return StringUtils.equals(artist, filter.artist) && StringUtils.equals(genre, filter.genre)
                    && StringUtils.equals(album, filter.album) && StringUtils.equals(title, filter.title);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (artist != null) ? artist.hashCode() : 0;
        hashCode += (genre != null) ? genre.hashCode() : 0;
        hashCode += (album != null) ? album.hashCode() : 0;
        hashCode += (title != null) ? title.hashCode() : 0;
        if (hashCode > 0)
            return hashCode;
        else
            return super.hashCode();

    }
}
