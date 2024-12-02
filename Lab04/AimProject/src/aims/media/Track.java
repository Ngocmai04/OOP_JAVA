package Lab04.AimProject.src.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        super();
        this.title = title;
        this.length = length;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    // Override equals() để so sánh Track theo title và length
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }

    // Triển khai play() từ Playable
    @Override
    public void play() {
        if (length > 0) {
            System.out.println("Playing Track: " + title);
            System.out.println("Track length: " + length);
        } else {
            System.out.println("Cannot play track. Invalid length.");
        }
    }

    // Override toString() để hiển thị thông tin
    @Override
    public String toString() {
        return "Track{title='" + title + "', length=" + length + "}";
    }
}
