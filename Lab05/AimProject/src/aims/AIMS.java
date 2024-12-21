package src.aims;
import src.aims.cart.Cart;
import src.aims.media.*;
import src.aims.store.*;
import src.aims.exception.PlayerException;
import java.util.Scanner;
import java.util.Iterator;


public class AIMS {

    
        public static void main(String[] args) {
            STORE STORE = new STORE();
            Cart cart = new Cart();
            Scanner scanner = new Scanner(System.in);
            int choice;
            STORE.initialize();
    
            do {
                showMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                try {
                    switch (choice) {
                        case 1:
                            viewSTORE(STORE, cart, scanner);
                            break;
                        case 2:
                            updateSTORE(STORE, scanner);
                            break;
                        case 3:
                            seeCurrentCart(cart, scanner);
                            break;
                        case 0:
                            System.out.println("Exiting the application...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose a number: 0-1-2-3");
                    }
                } catch (PlayerException e) {
                    // Handle exceptions that occur during media playback
                    System.out.println("An error occurred during media playback: " + e.getMessage());
                    e.printStackTrace(); // Print the stack trace for debugging
                }
    
            } while (choice != 0);
            scanner.close();
        }
    
        public static void showMenu() {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View STORE");
            System.out.println("2. Update STORE");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            System.out.print("Enter your choice: ");
        }
    
        public static void viewSTORE(STORE store, Cart cart, Scanner scanner) throws PlayerException {
            store.getItemsOrdered();
            int choice;
            do {
                showMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1:
                        seeCurrentCart(cart, scanner);
                        break;
                    case 2:
                        addMediaToCart(store, cart, scanner);
                        break;
                    case 3:
                        playMedia(store, scanner);
                        break;
                    case 4:
                        seeCurrentCart(cart, scanner);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4");
                }
            } while (choice != 0);
        }
    
        public static void playMedia(STORE store, Scanner scanner) {
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
    
            if (media != null && media instanceof Playable) {
                try {
                    ((Playable) media).play(); // Try to play the media
                } catch (PlayerException e) {
                    // Handle specific media play exception
                    System.out.println("Error while playing media: " + e.getMessage());
                    e.printStackTrace();  // Print detailed error
                }
            } else if (media == null) {
                System.out.println("Media not found.");
            } else {
                System.out.println("This media cannot be played.");
            }
        }
    
        // Other methods remain unchanged...
    
        public static void addMediaToCart(STORE STORE, Cart cart, Scanner scanner) {
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = STORE.searchByTitle(title);
            if (media != null) {
                cart.addMedia(media);
                System.out.println("Media added to cart.");
            } else {
                System.out.println("Media not found.");
            }
        }
    
        // Updated method for media playback handling when in cart
        public static void playMedia(Cart cart, Scanner scanner) {
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = cart.findMediaByTitle(title);
            if (media != null && media instanceof Playable) {
                try {
                    ((Playable) media).play(); // Attempt to play the media
                } catch (PlayerException e) {
                    System.out.println("Error while playing media: " + e.getMessage());
                    e.printStackTrace();  // Print detailed error information
                }
            } else if (media == null) {
                System.out.println("Media not found.");
            } else {
                System.out.println("This media cannot be played.");
            }
        }
    
        public static void updateSTORE(STORE STORE, Scanner scanner) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to STORE");
            System.out.println("2. Remove a media from STORE");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    // Add media to STORE logic
                    addMediaToSTORE(STORE, scanner);
                    break;
                case 2:
                    // Remove media from STORE logic
                    removeMediaFromSTORE(STORE, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2");
            }
        }
    
        public static void addMediaToSTORE(STORE STORE, Scanner scanner) {
            System.out.print("Enter the type of media (CD/DVD/Book): ");
            String type = scanner.nextLine();
    
            if (type.equalsIgnoreCase("DVD")) {
                System.out.println("Enter the ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the title:");
                String title = scanner.nextLine();
                System.out.println("Enter the category:");
                String category = scanner.nextLine();
                System.out.println("Enter the cost:");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Enter the director:");
                String director = scanner.nextLine();
                System.out.println("Enter the length:");
                int length = scanner.nextInt();
    
                DigitalVdDisc dvd = new DigitalVdDisc(id, title, category, cost, director, length);
                STORE.addMedia(dvd);
                System.out.println("DVD added to STORE.");
            } else if (type.equalsIgnoreCase("CD")) {
                System.out.println("Enter the ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the title:");
                String title = scanner.nextLine();
                System.out.println("Enter the category:");
                String category = scanner.nextLine();
                System.out.println("Enter the cost:");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Enter the director:");
                String director = scanner.nextLine();
                System.out.println("Enter the length:");
                int length = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the artist:");
                String artist = scanner.nextLine();
    
                CompactDisc cd = new CompactDisc(id, title, category, cost, director, length, artist);
                STORE.addMedia(cd);
                System.out.println("CD added to STORE.");
            } else if (type.equalsIgnoreCase("Book")) {
                System.out.println("Enter the ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the title:");
                String title = scanner.nextLine();
                System.out.println("Enter the category:");
                String category = scanner.nextLine();
                System.out.println("Enter the cost:");
                float cost = scanner.nextFloat();
    
                Book book = new Book(id, title, category, cost);
                STORE.addMedia(book);
                System.out.println("Book added to STORE.");
            } else {
                System.out.println("Invalid media type.");
            }
        }
    
        public static void removeMediaFromSTORE(STORE STORE, Scanner scanner) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            Media media = STORE.searchByTitle(title);
            if (media != null) {
                STORE.removeMedia(media);
            } else {
                System.out.println("Media not found.");
            }
        }
    
        public static void seeCurrentCart(Cart cart, Scanner scanner) throws PlayerException {
            cart.print();
            int choice;
            do {
                cartMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1:
                        // Filter medias in cart logic
                        filterMediasInCart(cart, scanner);
                        break;
                    case 2:
                        // Sort medias in cart logic
                        sortMediasInCart(cart, scanner);
                        break;
                    case 3:
                        // Remove media from cart logic
                        removeFromCart(cart, scanner);
                        break;
                    case 4:
                        // Play a media logic
                        playMedia(cart, scanner);
                        break;
                    case 5:
                        // Place order logic
                        placeOrder(cart);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4-5");
                }
            } while (choice != 0);
        }
    
        // Sort medias in cart logic
        public static void sortMediasInCart(Cart cart, Scanner scanner) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Sort by title");
            System.out.println("2. Sort by cost");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    cart.sortCart("title");
                break;
            case 2:
                cart.sortCart("cost");
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
        cart.print();
    }

    // Filter medias in cart logic
    public static void filterMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Filter by title logic
                System.out.print("Enter the title to filter: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            case 2:
                // Filter by ID logic
                System.out.print("Enter the ID to filter: ");
                int id = scanner.nextInt();
                cart.searchById(id);

                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }

    // Remove from a cart logic
    public static void removeFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(title);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // Play a media logic
    public static void play(Cart cart, Scanner scanner) throws PlayerException {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    // Place order logic
    public static void placeOrder(Cart cart) {
        Iterator<Media> iterator = cart.getItemsOrdered().iterator();
        while (iterator.hasNext()) {
            @SuppressWarnings("unused")
            Media inMedia = iterator.next();
            iterator.remove();
        }
        System.out.println("Order placed.");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        System.out.print("Enter your choice: ");
    }
}
