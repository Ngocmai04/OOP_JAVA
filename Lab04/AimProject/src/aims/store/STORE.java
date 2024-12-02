package Lab04.AimProject.src.aims.store;

import Lab04.AimProject.src.aims.media.Media;
import java.util.LinkedList;

public class STORE {
    private LinkedList<Media> itemsInStore = new LinkedList<Media>();

    // Kiểm tra phương tiện có trong cửa hàng hay không
    public boolean checkMedia(Media media) {
        for (Media item : itemsInStore) {
            if (item.equals(media)) {
                return true;  // Trả về true nếu tìm thấy phương tiện trong cửa hàng
            }
        }
        return false;  // Trả về false nếu không tìm thấy
    }

    // Xóa phương tiện khỏi cửa hàng
    public void removeMedia(Media media) {
        if (checkMedia(media)) {
            itemsInStore.remove(media);  // Xóa phương tiện khỏi danh sách
            System.out.println("The media has been deleted.");
        } else {
            System.out.println("Not found.");
        }
    }

    // Thêm phương tiện vào cửa hàng
    public void addMedia(Media media) {
        if (!checkMedia(media)) {  // Nếu phương tiện chưa có trong cửa hàng
            itemsInStore.add(media);  // Thêm phương tiện vào cửa hàng
            System.out.println("The media has been added.");
        } else {
            System.out.println("Media already exists in the store.");
        }
    }

    // In ra tất cả các phương tiện trong cửa hàng
    public void print() {
        StringBuilder output = new StringBuilder();
        for (Media media : itemsInStore) {
            output.append(media.get_Title()).append(" - ").append(media.get_Category()).append(" - ").append(media.get_Cost()).append(" $\n");
        }
        System.out.println(output.toString());
    }
}
