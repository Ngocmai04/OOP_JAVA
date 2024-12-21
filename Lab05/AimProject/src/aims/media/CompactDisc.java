package src.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.aims.exception.PlayerException;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor with artist as String and tracks as a List of Track objects
    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        if (tracks != null) {
            this.tracks = tracks;
        }
    }

    public CompactDisc(int id, String title, String category, float cost, int i, String string) {
       super(title, title, cost);
       
    }

    public CompactDisc(String title, String category, String string, int i, float cost) {
        super(title, title, cost);
    }

    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist2) {
        super(title, title, cost);
    }

    public CompactDisc(String string, String string2, double d) {
        super(string, string2, (float) d);
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // Add a track to the CD
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Remove a track from the CD
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track does not exist: " + track.getTitle());
        }
    }

    // Calculate the total length of all tracks
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Implement play() method
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // Get an iterator for the tracks
            Iterator<Track> iterator = tracks.iterator();
            Track nextTrack;
            
            // Iterate through all tracks
            while (iterator.hasNext()) {
                nextTrack = iterator.next();  // Get the next track in the iterator
                try {
                    nextTrack.play();  // Attempt to play the track
                } catch (PlayerException e) {
                    throw e;  // Propagate the exception if it occurs
                }
            }
        } else {
            System.out.println("No tracks to play.");
        }
    }

    // Set the artist's name
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Get the list of tracks
    public List<Track> getTracks() {
        return tracks;
    }

    // Set the list of tracks
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    // Override toString() to display CD information
    @Override
    public String toString() {
        StringBuilder trackInfo = new StringBuilder();
        for (Track track : tracks) {
            trackInfo.append(track.toString()).append("\n");
        }
        return super.toString() +
               ", artist='" + artist + '\'' +
               ", totalLength=" + getLength() +
               "\nTracks:\n" + trackInfo;
    }
}
