package Lab04.AimProject.src.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    // Getter
    public String getArtist() {
        return artist;
    }

    // Thêm bản nhạc vào CD
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Xóa bản nhạc khỏi CD
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track does not exist: " + track.getTitle());
        }
    }

    // Tính tổng độ dài của tất cả các bản nhạc
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Triển khai phương thức play()
    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("No tracks to play.");
        } else {
            System.out.println("Playing CD: " + get_Title());
            System.out.println("Artist: " + artist);
            for (Track track : tracks) {
                track.play(); // Gọi play() của từng Track
            }
        }
    }

    // Override toString() để hiển thị thông tin
    @Override
    public String toString() {
        StringBuilder trackInfo = new StringBuilder();
        for (Track track : tracks) {
            trackInfo.append(track.toString()).append("\n");
        }
        return super.toString() +", artist='" + artist + '\'' +", totalLength=" + getLength() +"\nTracks:\n" + trackInfo;
    }
}
