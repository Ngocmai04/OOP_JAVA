package src.aims.media;



public class Disc extends Media {
    public int length;
    public String director;

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(title, category, cost); // Gọi constructor của lớp Media
        this.length = length;
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void displayDetails() {
        System.out.print(get_ID() + ". Book - " + get_Title() + " - " + get_Category() + " : ");
       
        System.out.println(get_Cost() + "$");
    }
   
    

}
