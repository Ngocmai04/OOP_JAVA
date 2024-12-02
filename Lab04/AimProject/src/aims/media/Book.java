package Lab04.AimProject.src.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book( String title, String category, float cost) {
        super( title, category, cost);
    }
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author does not exist: " + authorName);
        }
    }
    public List<String> getAuthors() {
        return authors;
    }
    @Override
    public String toString() {
        return super.toString() + ", authors=" + authors;
    }
}
