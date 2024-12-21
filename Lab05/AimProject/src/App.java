package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create buttons for cart actions
        Button btnAddToCart = new Button("Add to Cart");
        btnAddToCart.setOnAction(event -> System.out.println("Item added to cart"));

        Button btnRemoveFromCart = new Button("Remove from Cart");
        btnRemoveFromCart.setOnAction(event -> System.out.println("Item removed from cart"));

        Button btnViewCart = new Button("View Cart");
        btnViewCart.setOnAction(event -> System.out.println("Viewing cart"));

        // Create a layout container
        StackPane root = new StackPane();
        
        // Arrange the buttons vertically by adding them one by one
        root.getChildren().addAll(btnAddToCart, btnRemoveFromCart, btnViewCart);

        // You can adjust the position of the buttons in the layout
        StackPane.setMargin(btnAddToCart, new javafx.geometry.Insets(0, 0, 30, 0)); // Adjust margin for positioning
        StackPane.setMargin(btnRemoveFromCart, new javafx.geometry.Insets(0, 0, 60, 0));
        StackPane.setMargin(btnViewCart, new javafx.geometry.Insets(0, 0, 90, 0));

        // Set up the scene and stage
        primaryStage.setTitle("Cart Example");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
