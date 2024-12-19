import javax.swing.*;
import java.awt.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 400);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        for (int i = 0; i < 10; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(e -> {
                tfDisplay.setText(tfDisplay.getText() + e.getActionCommand());
            });
        }

        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(e -> tfDisplay.setText(""));

        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(e -> {
            String currentText = tfDisplay.getText();
            if (!currentText.isEmpty()) {
                tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
            }
        });
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
