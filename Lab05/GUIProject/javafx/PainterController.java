package javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup toggleGroup; // Reference to the ToggleGroup to check the selected tool

    private boolean isEraserSelected = false; // Flag to track if the eraser is selected

    // Initialize the controller, where we check the initial state of the selected tool
    @FXML
    public void initialize() {
        penRadioButton.setSelected(true); // Default is Pen selected
        toggleGroup = new ToggleGroup(); // Instantiate the ToggleGroup
        penRadioButton.setToggleGroup(toggleGroup);
        eraserRadioButton.setToggleGroup(toggleGroup);
        
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == eraserRadioButton) {
                isEraserSelected = true;
            } else {
                isEraserSelected = false;
            }
        });
    }

    // Clear the drawing area when the Clear button is pressed
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    // Handle the drawing and erasing when the mouse is dragged
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color colorToUse = isEraserSelected ? Color.WHITE : Color.BLACK; // Use white for eraser

        // Create a circle at the mouse position
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, colorToUse);

        // Add the circle to the drawing area
        drawingAreaPane.getChildren().add(newCircle);
    }
}