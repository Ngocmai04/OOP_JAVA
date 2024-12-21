package src.aims.screen;

import javax.swing.JOptionPane;
import src.aims.media.DigitalVdDisc;
import src.aims.store.STORE;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private STORE store;

    // Constructor to initialize the screen and the store
    public AddDigitalVideoDiscToStoreScreen(STORE store) {
        super("DVD");
        this.store = store;
    }

    @Override
    protected void addItem() {
        // Retrieve input values from text fields
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        // Create a new DigitalVdDisc object
        DigitalVdDisc dvd = new DigitalVdDisc(title, category, "Unknown", 120, cost);

        // Add the new DVD to the store
        store.addMedia(dvd);

        // Show a confirmation message to the user
        JOptionPane.showMessageDialog(this, "DVD added to store!");
    }
}
