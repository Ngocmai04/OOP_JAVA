package src.aims.screen;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.scene.media.Media;
import javafx.scene.media.Track;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.aims.media.Book;
import src.aims.media.CompactDisc;
import src.aims.store.STORE;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(STORE store) {
        super("CD");
    }

    public void AddBookStoreScreen(STORE store) {
        // Set up the layout
        this.setLayout(new GridLayout(4, 2, 5, 5));
        
        // Add title label and text field
        this.add(new JLabel("Enter title: "));
        JTextField titleField = new JTextField();
        this.add(titleField);

        // Add category label and text field
        this.add(new JLabel("Enter category: "));
        JTextField categoryField = new JTextField();
        this.add(categoryField);

        // Add cost label and text field
        this.add(new JLabel("Enter cost: "));
        JTextField costField = new JTextField();
        this.add(costField);

        // Add the "Add" button
        JButton addButton = new JButton("Add");
        this.add(addButton);

        // Add button click listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse input and create a new Book
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    float cost = Float.parseFloat(costField.getText());
                    Book book = new Book(2, title, category, cost);

                    // Add the book to the store
                    store.addMedia(book);

                    // Clear input fields
                    titleField.setText("");
                    categoryField.setText("");
                    costField.setText("");

                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid cost input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set JFrame properties
        this.setTitle("Add Book");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    protected void addItem() {
        // Retrieve input values from text fields
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        // Create a new CompactDisc object
    Media media = new Media(title);

    // Add the new CD to the store
    store.addMedia(media);
        // Show a confirmation message to the user
        JOptionPane.showMessageDialog(this, "CD added to store!");
    }

    

}
