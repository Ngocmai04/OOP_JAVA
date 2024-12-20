package src.aims.screen;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class StoreScreen1 extends JFrame {
    private Store store;

    public Store getStore() {
        return store;
    }

    public StoreScreen1(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Screen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome to the Store");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        header.add(title);

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) { // Ensure we don't exceed the size of the list
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public static void main(String[] args) {
        Store store = new Store(); // Replace with actual Store object initialization
        new StoreScreen1(store);
    }
}

// Dummy MediaStore class implementation
class MediaStore extends JPanel {
    public MediaStore(Media media) {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.CENTER);
    }
}

// Dummy Store class implementation
class Store {
    private ArrayList<Media> items;

    public Store() {
        items = new ArrayList<>();
        // Populate store with dummy data
        items.add(new Media("Book 1", null, 0));
        items.add(new Media("Book 2", null, 0));
        items.add(new Media("CD 1", null, 0));
        items.add(new Media("DVD 1", null, 0));
    }

    public ArrayList<Media> getItemsInStore() {
        return items;
    }
}

// Dummy Media class implementation
class Media {
    private String title;

    public Media(String title, String category, float cost) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // public float get_Cost() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'get_Cost'");
    // }

    // public String get_Title() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'get_Title'");
    // }
}
