import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import SwingAccumulator;


private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Lấy tên nút đã nhấn

        switch (command) {
            case "C": // Nút Reset
                tfDisplay.setText(""); // Xóa toàn bộ nội dung
                break;

            case "DEL": // Nút Delete
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    // Xóa ký tự cuối cùng trong JTextField
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
                break;

            default: // Nút số
                // Thêm số vào JTextField
                tfDisplay.setText(tfDisplay.getText() + command);
                break;
        }
    }
}
