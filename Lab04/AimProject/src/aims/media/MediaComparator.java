package Lab04.AimProject.src.aims.media;
import java.util.Comparator;


public class MediaComparator {
    // Comparator sắp xếp theo tên (title)
    public static Comparator<Media> COMPARE_BY_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            return m1.get_Title().compareTo(m2.get_Title());
        }
    };

    // Comparator sắp xếp theo giá (cost)
    public static Comparator<Media> COMPARE_BY_COST = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            return Float.compare(m1.get_Cost(), m2.get_Cost());
        }
    };
}
