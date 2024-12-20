package src.aims.screen;

import javax.swing.JOptionPane;

import src.aims.media.CompactDisc;
import src.aims.store.STORE;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private STORE store;

    public AddCompactDiscToStoreScreen(STORE store) {
        super("CD");
        this.store = store;
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        CompactDisc cd = new CompactDisc(title, category, "Unknown", 10, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added to store!");
    }
}
