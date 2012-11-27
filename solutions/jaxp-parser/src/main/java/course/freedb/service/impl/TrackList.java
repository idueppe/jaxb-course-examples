package course.freedb.service.impl;

import java.util.Vector;
import java.util.EventListener;
import javax.swing.event.ListDataListener;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataEvent;

import course.freedb.domain.Track;
import course.freedb.service.ITrackFilter;
import course.freedb.service.ITrackList;

/**
 * @author Ingo Düppe
 * @version 1.0
 */
public class TrackList implements ITrackList {
    private Vector<Track> tracks;
    private EventListenerList listenerList;

    private ITrackFilter filter;
    
    private boolean isUpdating;

    public TrackList() {
        tracks = new Vector<Track>();
        listenerList = new EventListenerList();
        isUpdating = false;
    }

    public TrackList(ITrackFilter filter) {
        this();
        this.filter = filter;
    }

    public void setFilter(ITrackFilter filter) {
        this.filter = filter;
    }

    public int length() {
        return tracks.size();
    }

    public Track getTrack(int index) {
        return tracks.get(index);
    }

    public void appendTrack(Track track) {
        if (filter == null || filter.matches(track)) {
            tracks.add(track);
            if (!isUpdating)
                fireDataChange(tracks.size() - 2, tracks.size() - 1);
        }
    }

    private void fireDataChange(int startIndex, int stopIndex) {
        if (listenerList.getListenerCount() > 0) {
            EventListener[] listeners = listenerList.getListeners(ListDataListener.class);
            ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, startIndex, stopIndex);
            for (int i = 0; i < listeners.length; i++) {
                ((ListDataListener) listeners[i]).intervalAdded(event);
            }
        }
    }

    public void addListDataListener(ListDataListener listener) {
        listenerList.add(ListDataListener.class, listener);
    }

    public void removeListDataListener(ListDataListener listener) {
        listenerList.remove(ListDataListener.class, listener);
    }
    
    public void startUpdating() {
        isUpdating = true;
    }
    
    public void finishedUpdating() {
        isUpdating = false;
        refresh();
    }
    

    public void refresh() {
        fireDataChange(0, tracks.size() - 1);
    }
}