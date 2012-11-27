package course.freedb.service;

import javax.swing.event.ListDataListener;

import course.freedb.domain.Track;


/**
 * @author: Ingo Düppe
 * 
 * www.dueppe.com
 */
public interface ITrackList {
    public abstract void setFilter(ITrackFilter filter);

    public abstract int length();

    public abstract Track getTrack(int index);

    public abstract void appendTrack(Track track);

    public abstract void addListDataListener(ListDataListener listener);

    public abstract void removeListDataListener(ListDataListener listener);

    public abstract void refresh();
    
    public abstract void startUpdating();
   
    public abstract void finishedUpdating(); 
}