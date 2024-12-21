// package src.aims.screen;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Scene;
// import javafx.scene.layout.AnchorPane;
// import javafx.stage.Stage;
// import src.aims.cart.Cart;


// import java.io.IOException;

// public class App extends Application {

//     private Cart cart;

//     public App() {
//         cart = new Cart(); // Tạo giỏ hàng mới
//     }

//     @Override
//     public void start(Stage primaryStage) throws IOException {
//         // Tải FXML và controller
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/CartScreen.fxml")); // Đảm bảo đường dẫn đúng
//         AnchorPane root = loader.load();

//         // Cấu hình controller
//         CartScreenController controller = loader.getController();
//         controller.setCart(cart); // Đảm bảo controller nhận được đối tượng cart

//         // Hiển thị giao diện
//         Scene scene = new Scene(root);
//         primaryStage.setTitle("AIMS Cart");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args); // Khởi chạy ứng dụng JavaFX
//     }
// }
