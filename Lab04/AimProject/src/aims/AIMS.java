package Lab04.AimProject.src.aims;

import Lab04.AimProject.src.aims.cart.Cart;
import Lab04.AimProject.src.aims.media.*;
import Lab04.AimProject.src.aims.store.STORE;

import java.util.Scanner;

public class AIMS {
    private static Scanner scanner = new Scanner(System.in);
    private static STORE store = new STORE();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        // Tạo các phương tiện mẫu trong cửa hàng
        createSampleStore();

        // Hiển thị menu chính
        showMenu();
    }

    // Hiển thị menu chính
    public static void showMenu() {
        int choice;
        do {
            System.out.println("AIMS: ");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.print("Please choose a number: 0-1-2-3: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    // Hiển thị menu cửa hàng
    public static void storeMenu() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    // Hiển thị chi tiết phương tiện
    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        cart.searchByTitle(title);
    }

    // Thêm phương tiện vào giỏ hàng
    public static void addMediaToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();
        // Giả sử người dùng muốn thêm phương tiện này vào giỏ hàng
        Media media = store.searchByTitle(title);  // tìm kiếm phương tiện theo tiêu đề
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    // Phát phương tiện
    public static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);  // Tìm kiếm phương tiện
        if (media != null) {
            media.play();
        } else {
            System.out.println("Media not found.");
        }
    }

    // Cập nhật cửa hàng
    public static void updateStoreMenu() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.print("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    // Thêm phương tiện vào cửa hàng
    public static void addMediaToStore() {
        System.out.print("Enter media title to add to store: ");
        String title = scanner.nextLine();
        Media media = new DigitalVdDisc(title, "Sci-fi", "Director", 19.99f);
        store.addMedia(media);
    }

    // Xóa phương tiện khỏi cửa hàng
    public static void removeMediaFromStore() {
        System.out.print("Enter media title to remove from store: ");
        String title = scanner.nextLine();
        Media media = new DigitalVdDisc(title, "Sci-fi", "Director", 19.99f);
        store.removeMedia(media);
    }

    // Hiển thị menu giỏ hàng
    public static void cartMenu() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    // Lọc phương tiện trong giỏ hàng
    public static void filterMediasInCart() {
        // Lọc theo title hoặc ID
    }

    // Sắp xếp phương tiện trong giỏ hàng
    public static void sortMediasInCart() {
        // Sắp xếp theo title hoặc cost
    }

    // Xóa phương tiện khỏi giỏ hàng
    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove from cart: ");
        String title = scanner.nextLine();
        // Giả sử phương tiện đã được thêm vào giỏ hàng, thực tế cần thêm mã để xác thực
        Media media = new DigitalVdDisc(title, "Sci-fi", "Director", 19.99f);
        cart.removeMedia(media);
    }

    // Đặt hàng
    public static void placeOrder() {
        System.out.println("Order has been placed!");
        cart.print();  // In giỏ hàng
        // Giả sử đặt hàng và thanh toán
    }

    // Tạo các phương tiện mẫu cho cửa hàng
    public static void createSampleStore() {
        Media dvd1 = new DigitalVdDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 19.99f);
        Media cd1 = new CompactDisc("Greatest Hits", "Music", 15.0f, "Artist A");
       
        store.addMedia(dvd1);
        store.addMedia(cd1);
        
}
}
