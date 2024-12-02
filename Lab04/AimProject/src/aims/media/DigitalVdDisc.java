package Lab04.AimProject.src.aims.media;

public class DigitalVdDisc extends Media implements Playable {
    private String director;
    private int length;

    // Constructor 1
    public DigitalVdDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    // Constructor 2
    public DigitalVdDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Constructor 3
    public DigitalVdDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getter và Setter giữ đúng tên
    public String get_Director() {
        return director;
    }

    public void set_Director(String director) {
        this.director = director;
    }

    public int get_Length() {
        return length;
    }

    public void set_Length(int length) {
        this.length = length;
    }

    // Triển khai phương thức play() từ Playable
    @Override
    public void play() {
        if (get_Length() > 0) {
            System.out.println("Playing DVD: " + get_Title());
            System.out.println("DVD length: " + get_Length());
        } else {
            System.out.println("Cannot play this DVD. Invalid length.");
        }
    }

    // Override toString() để hiển thị thông tin chi tiết
    @Override
    public String toString() {
        return super.toString() +
                ", director='" + director + '\'' +
                ", length=" + length;
    }
}
