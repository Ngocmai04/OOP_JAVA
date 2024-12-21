package src.aims.screen;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected JTextField titleField, categoryField, costField;

    public AddItemToStoreScreen(String itemType) {
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Enter Title: "));
        titleField = new JTextField(10);
        add(titleField);

        add(new JLabel("Enter Category: "));
        categoryField = new JTextField(10);
        add(categoryField);

        add(new JLabel("Enter Cost: "));
        costField = new JTextField(10);
        add(costField);

        JButton addButton = new JButton("Add " + itemType);
        addButton.addActionListener(e -> addItem());
        add(addButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected abstract void addItem();
}
