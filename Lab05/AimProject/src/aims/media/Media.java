package src.aims.media;

import java.util.Comparator;

public abstract class Media {
    @SuppressWarnings("rawtypes")
    public static final Comparator COMPARE_BY_TITLE_COST = null;
    private static int idCounter = 0; // Tạo ID tự động
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media(String title2, String title, float cost) {
        this.id = ++idCounter;
        this.title = title;
        
        this.cost = cost;
    }

    // Getter và Setter với tên giữ nguyên
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

    // Override equals() để so sánh các Media theo title
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return title != null && title.equals(media.title);
    }

    // Override toString() để hiển thị thông tin cơ bản của Media
    @Override
    public String toString() {
        return "Media{id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost + '}';
    }

   

  
}


