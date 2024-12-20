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
        // Create a button
        Button btn = new Button("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("Hello World"));

        // Create a layout container
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Set up the scene and stage
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
