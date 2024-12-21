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

    // Add a single media item to the cart
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

    // Add multiple media items to the cart
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

    // Remove a media item from the cart by its title
    public void removeMedia(String title) {
        if (itemOrdered.remove(title)) {
            System.out.println("Media removed: " + title);
        } else {
            System.out.println("No matching media found.");
        }
    }

    // Calculate the total cost of the cart
    public float totalCost() {
        float sum = 0;
        for (Media media : itemOrdered) {
            sum += media.get_Cost();
        }
        return sum;
    }

    // Print the contents of the cart
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

    // Search for a media item by its ID
    public void searchById(int id) {
        for (Media media : itemOrdered) {
            if (media.get_ID() == id) {
                System.out.println("Result: [" + media.get_Title() + "] - [" + media.get_Category() +
                                   "] - [" + media.get_Cost() + " $]");
                return;
            }
        }
        System.out.println("Not found!");
    }

    // Search for a media item by its title
    public Media searchByTitle(String title) {
        for (Media media : itemOrdered) {
            if (media.get_Title().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("No media found with the title: " + title);
        return null;
    }

    // Sort the cart by title or cost
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

    // Get the items ordered as an ObservableList
    public ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemOrdered);
    }

   
}
