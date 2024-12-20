package src.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import src.aims.cart.Cart;

public class CartScreen extends JFrame {
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartScreen(Cart cart) {
        super("Cart");  // Đặt tiêu đề cho JFrame

        this.cart = cart;

        // Khởi tạo JFXPanel
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        // Cấu hình JFrame
        this.setSize(800, 600);  // Đặt kích thước JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Khởi tạo JavaFX trong đúng thread
        SwingUtilities.invokeLater(() -> Platform.runLater(() -> {
            try {
                // Tải file FXML và set controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                CartScreenController controller = new CartScreenController(cart);
                loader.setController(controller);
                Parent root = loader.load();
                
                // Thiết lập Scene cho JFXPanel
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();  // Xử lý lỗi khi không thể tải FXML
            }
        }));

        // Hiển thị JFrame
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Cart cart = new Cart();  // Tạo đối tượng Cart (bạn cần cài đặt Cart)
        new CartScreen(cart);
    }
}
