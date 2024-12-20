package src.aims.store;

import src.aims.media.Media;
import java.util.ArrayList;
import java.util.LinkedList;

public class STORE {
    private LinkedList<Media> itemsInStore = new LinkedList<Media>();

    // Kiểm tra phương tiện có trong cửa hàng hay không
    public boolean checkMedia(Media media) {
        return itemsInStore.contains(media);  // Dùng contains() thay vì vòng lặp thủ công
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

    // Tìm kiếm phương tiện theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.get_Title().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // In ra tất cả các phương tiện trong cửa hàng
    public void print() {
        StringBuilder output = new StringBuilder();
        for (Media media : itemsInStore) {
            output.append(media.get_Title())
                  .append(" - ")
                  .append(media.get_Category())
                  .append(" - ")
                  .append(media.get_Cost())
                  .append(" $\n");
        }
        System.out.println(output.toString());
    }

    // Phương thức trả về danh sách các phương tiện đã được sắp xếp theo một tiêu chí nào đó (ví dụ: tên, giá cả,...)
    public ArrayList<Media> getItemsOrdered() {
        // Thực hiện sắp xếp, giả sử chúng ta sắp xếp theo tên
        ArrayList<Media> orderedList = new ArrayList<>(itemsInStore);
        orderedList.sort((media1, media2) -> media1.get_Title().compareToIgnoreCase(media2.get_Title()));
        return orderedList;
    }
}
