package Lab04.AimProject.src.aims.cart;

// import Lab04.AimProject.src.aims.media.Media;  
import Lab04.AimProject.src.aims.media.*;


import java.util.ArrayList;
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
    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < itemOrdered.size(); i++) {
            if (itemOrdered.get(i).equals(media)) {
                found = true;
                itemOrdered.remove(i);
                System.out.println("Media removed: " + media.get_Title());
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
                    .append(media.get_Cost()).append(" $\n");
        }
        output.append("Total: ").append(totalCost()).append(" $\n");
        System.out.println(output);
    }

    // Tìm kiếm theo ID (theo số thứ tự trong giỏ hàng)
    public void searchById(int id) {
        if (id > itemOrdered.size() || id <= 0) {
            System.out.println("Not found!");
        } else {
            Media foundMedia = itemOrdered.get(id - 1);
            System.out.println("Result: [" + foundMedia.get_Title() + "] - [" + foundMedia.get_Category() +
                    "] - [" + foundMedia.get_Cost() + " $\n");
        }
    }

    // Tìm kiếm theo tên tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemOrdered) {
            if (media.get_Title().equalsIgnoreCase(title)) {
                System.out.println("Result: [" + media.get_Title() + "] - [" + media.get_Category() +
                        "] - [" + media.get_Cost() + " $\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found.");
        }
    }
}
