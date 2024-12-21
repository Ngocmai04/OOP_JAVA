package src.aims.media;

import java.util.Comparator;

public abstract class Media {
  
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            // So sánh theo tên, nếu tên giống nhau thì so sánh theo chi phí
            int titleComparison = media1.get_Title().compareToIgnoreCase(media2.get_Title());
            if (titleComparison != 0) {
                return titleComparison;
            } else {
                return Float.compare(media1.get_Cost(), media2.get_Cost());
            }
        }
    };
    
    private static int idCounter = 0; // Tạo ID tự động
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media(String title, String category, float cost) {
        this.id = ++idCounter;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    

    // Getter và Setter
    public int get_ID() {
        return id;
    }

    public String get_Title() {
        return title;
    }

    public void set_Title(String title) {
        this.title = title;
    }

    public String get_Category() {
        return category;
    }

    public void set_Category(String category) {
        this.category = category;
    }

    public float get_Cost() {
        return cost;
    }

    public void set_Cost(float cost) {
        this.cost = cost;
    }

    // Override equals() để so sánh các Media theo id và title
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return id == media.id && title.equals(media.title) && category.equals(media.category);
    }

    // Override toString() để hiển thị thông tin cơ bản của Media
    @Override
    public String toString() {
        return "Media{id=" + id + "\n" +
                "title='" + title + '\'' + "\n" +
                "category='" + category + '\'' + "\n" +
                "cost=" + cost + '}';
    }
}
