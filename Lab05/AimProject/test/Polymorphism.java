package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.aims.media.Book;
import src.aims.media.CompactDisc;
import src.aims.media.DigitalVdDisc;
import src.aims.media.Media;  // Assuming your Media class is in this package
import src.aims.media.MediaComparator;  // Import the MediaComparator

public class Polymorphism {

    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();
        
        // Create Book objects
        Book book1 = new Book(1, "The Great Gatsby", "Fiction", 10.99f);
        Book book2 = new Book(2, "1984", "Dystopian", 12.50f);
        
        // Create CompactDisc objects
        CompactDisc cd1 = new CompactDisc(3, "Back in Black", "Rock", 15.99f, 100, "AC/DC");
        CompactDisc cd2 = new CompactDisc(4, "Thriller", "Pop", 18.00f, 100, "Michael Jackson");
        
        // Create DigitalVdDisc objects
        DigitalVdDisc dvd1 = new DigitalVdDisc(5, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan");
        DigitalVdDisc dvd2 = new DigitalVdDisc(6, "The Dark Knight", "Action", 17.99f, 152, "Christopher Nolan");
        
        // Add media items to the list
        mediae.add(book1);
        mediae.add(book2);
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(cd1);
        mediae.add(cd2);
        
        // Print all media
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        // Create a new list of media for sorting
        List<Media> mediaList = new ArrayList<>();

        // Add media items
        mediaList.add(new Book(7, "The Great Gatsby", "Fiction", 10.99f));
        mediaList.add(new Book(8, "1984", "Dystopian", 18.99f));
        mediaList.add(new DigitalVdDisc(9, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan"));
        mediaList.add(new DigitalVdDisc(10, "Inception", "Sci-Fi", 18.99f, 148, "Christopher Nolan"));
        mediaList.add(new CompactDisc(11, "Thriller", "Pop", 18.00f, 0, "Michael Jackson"));

        // Sort by Title then Cost
        System.out.println("Sorted by Title then Cost:");
        Collections.sort(mediaList, MediaComparator.COMPARE_BY_TITLE.thenComparing(MediaComparator.COMPARE_BY_COST));
        mediaList.forEach(media -> System.out.println(media.get_Title() + " - " + media.get_Cost()));

        // Sort by Cost then Title
        System.out.println("\nSorted by Cost then Title:");
        Collections.sort(mediaList, MediaComparator.COMPARE_BY_COST.thenComparing(MediaComparator.COMPARE_BY_TITLE));
        mediaList.forEach(media -> System.out.println(media.get_Title() + " - " + media.get_Cost()));
    }
}
