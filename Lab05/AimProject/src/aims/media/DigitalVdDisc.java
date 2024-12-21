package src.aims.media;

public class DigitalVdDisc extends Media implements Playable {
    private String director;
    private int length;

    // Constructor
    public DigitalVdDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public DigitalVdDisc(int i, String string, String string2, float f, int j, String string3) {
        super(string2, string3, j);

    }

    public DigitalVdDisc(int id, String title, String category, float cost, String director2, int length2) {
      super(title, category, cost);
    }

    // Getter and Setter methods following Java conventions
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Implement play() from Playable interface
    @Override
    public void play() {
        if (getLength() > 0 && director != null && !director.isEmpty()) {
            System.out.println("Playing DVD: " + get_Title());
            System.out.println("Director: " + director);
            System.out.println("DVD length: " + getLength() + " minutes");
        } else {
            System.out.println("Cannot play this DVD. Invalid length or missing director.");
        }
    }

    // Override toString() to display DVD details
    @Override
    public String toString() {
        return super.toString() +
                ", Director='" + director + '\'' +
                ", Length=" + length + " minutes";
    }
}
