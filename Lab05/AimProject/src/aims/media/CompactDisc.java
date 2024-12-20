import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        if (tracks != null) {
            this.tracks = tracks;
        }
    }

    // Getter
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
    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("No tracks to play.");
        } else {
            System.out.println("Playing CD: " + get_Title());
            System.out.println("Artist: " + artist);
            for (Track track : tracks) {
                track.play(); // Call play() on each Track
            }
        }
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
