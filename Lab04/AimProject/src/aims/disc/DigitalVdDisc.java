package Lab04.AimProject.src.aims.disc;

public class DigitalVdDisc {
	private static int cnt_Disc=0;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	// private static int nbDigitalVdDisc=0;

	 public DigitalVdDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
       	this.cost = cost;
        this.id = ++cnt_Disc; 
    }
	public DigitalVdDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;  
        this.cost = cost;
        this.id = ++cnt_Disc; 
    }
	public DigitalVdDisc(String title) {
        this.title = title;
        
    }
    public DigitalVdDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++cnt_Disc; 
    }
	public String get_Title() {
		return title;
	}
	public String get_Category() {
		return category;
	}
	public String get_Director() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public int get_ID() {
		return id;
	}
	public float get_Cost() {
		return cost;
	}
	public void set_Title(String title_set) {
		title=title_set;
	}
	public void set_Category(String title_cate) {
		category=title_cate;
	}
	public void set_Director(String title_Dir) {
		director=title_Dir;
	}
	public void set_Length(int len_set) {
		length=len_set;
	}
	public void setCost(float costt) {
		cost=costt;
	}
}
