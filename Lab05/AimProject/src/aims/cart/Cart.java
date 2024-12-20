package src.aims.cart;

import src.aims.media.MediaComparator;
import src.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private static final int MAX_NUMBER_ORDER = 20;
    private List<Media> itemOrdered = new ArrayList<>();

    // Thêm phương tiện vào giỏ hàng (thêm một phương tiện)
    public int addMedia(Media media) {
        if (itemOrdered.size() == MAX_NUMBER_ORDER) {
            System.out.println("The cart is full");
            return 0;
        } else {
            itemOrdered.add(media);
            System.out.println("The media has been added: " + media.get_Title());
            return 1;
        }
    }

    // Thêm nhiều phương tiện vào giỏ hàng
    public int addMedia(Media... mediaArray) {
        int addCount = 0;
        for (Media media : mediaArray) {
            if (itemOrdered.size() == MAX_NUMBER_ORDER) {
                System.out.println("The cart is almost full. Can't add more.");
                break;
            } else {
                itemOrdered.add(media);
                System.out.println("The media \"" + media.get_Title() + "\" has been added!");
                addCount++;
            }
        }
        return addCount;
    }

    // Xóa phương tiện khỏi giỏ hàng
    public void removeMedia(String title) {
        boolean found = false;
        for (int i = 0; i < itemOrdered.size(); i++) {
            if (itemOrdered.get(i).get_Title().equalsIgnoreCase(title)) {
                found = true;
                Media removedMedia = itemOrdered.remove(i);
                System.out.println("Media removed: " + removedMedia.get_Title());
                break;
            }
        }
        if (!found) {
            System.out.println("No matching media found.");
        }
    }

    // Tính tổng giá trị của giỏ hàng
    public float totalCost() {
        float sum = 0;
        for (Media media : itemOrdered) {
            sum += media.get_Cost();
        }
        return sum;
    }

    // In ra các phương tiện trong giỏ hàng
    public void print() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < itemOrdered.size(); i++) {
            Media media = itemOrdered.get(i);
            output.append(i + 1).append(". [").append(media.get_Title()).append("] - [")
                  .append(media.get_Category()).append("] - [")
                  .append(media.get_Cost()).append(" $]\n");
        }
        output.append("Total: ").append(totalCost()).append(" $\n");
        System.out.println(output);
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        if (id > itemOrdered.size() || id <= 0) {
            System.out.println("Not found!");
        } else {
            Media foundMedia = itemOrdered.get(id - 1);
            System.out.println("Result: [" + foundMedia.get_Title() + "] - [" + foundMedia.get_Category() +
                               "] - [" + foundMedia.get_Cost() + " $]");
        }
    }

    // Tìm kiếm theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemOrdered) {
            if (media.get_Title().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("No media found with the title: " + title);
        return null;
    }

    // Sắp xếp giỏ hàng
    public void sortCart(String sortBy) {
        if (sortBy.equalsIgnoreCase("title")) {
            Collections.sort(itemOrdered, MediaComparator.COMPARE_BY_TITLE);
        } else if (sortBy.equalsIgnoreCase("cost")) {
            Collections.sort(itemOrdered, MediaComparator.COMPARE_BY_COST);
        } else {
            System.out.println("Invalid sorting option.");
        }
        print();
    }

    // Trả về danh sách phương tiện dưới dạng ObservableList
    public ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemOrdered);
    }
}
