package course.freedb.service;



/**
 * @author: Ingo Düppe
 * 
 * www.dueppe.com
 */
public interface IFreeDBDictionary {
	
    public abstract ITrackList findTracks(ITrackFilter filter);
    
}