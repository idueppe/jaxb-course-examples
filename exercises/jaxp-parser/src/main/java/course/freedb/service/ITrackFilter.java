package course.freedb.service;

import course.freedb.domain.Track;

public interface ITrackFilter {

	public abstract boolean matches(Track track);

	public abstract String getName();

}