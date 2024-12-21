package src.aims.screen;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.aims.cart.Cart;
import src.aims.media.Media;
import src.aims.media.Playable;

import java.util.ArrayList;

public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Label totalPrice;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Set up columns in the table
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Populate the table with the cart items
        tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart"));

        // Hide Play and Remove buttons initially
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Remove media when the Remove button is clicked
        btnRemove.setOnAction(event -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media != null) {
                cart.removeMedia(media);
                updateTotalPrice();
                tblMedia.refresh(); // Refresh table to reflect changes
            }
        });

        // Filter media based on the text field
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilterMedia(newValue));

        // Update buttons when selection changes
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldMedia, newMedia) -> updateButtonBar(newMedia));

        updateTotalPrice(); // Update the total price on startup

        // Play media when the Play button is clicked
        btnPlay.setOnAction(event -> {
            Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
            if (selectedMedia instanceof Playable) {
                Alert playAlert = new Alert(Alert.AlertType.INFORMATION);
                playAlert.setTitle("Playing Media");
                playAlert.setHeaderText(null);
                playAlert.setContentText("Playing: " + selectedMedia.get_Title());
                playAlert.showAndWait();
            }
        });

        // Place order when the Place Order button is clicked
        btnPlaceOrder.setOnAction(event -> {
            createPopUp();
            cart.getItemsOrdered().clear(); // Clear the cart after placing the order
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered())); // Update table
            updateTotalPrice(); // Reset the total price
        });
    }

    // Update the total price label
    private void updateTotalPrice() {
        totalPrice.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    // Show/hide buttons depending on the media selected
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(media != null);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    // Show filtered media based on filter criteria
    private void showFilterMedia(String filter) {
        if (filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
            ArrayList<Media> filterByTitle = new ArrayList<>();
            for (Media item : cart.getItemsOrdered()) {
                if (item.get_Title().toLowerCase().contains(filter.toLowerCase())) {
                    filterByTitle.add(item);
                }
            }
            tblMedia.setItems(FXCollections.observableList(filterByTitle));
        } else if (filterCategory.getSelectedToggle() == radioBtnFilterId) {
            try {
                int id = Integer.parseInt(filter);
                ArrayList<Media> filterByID = new ArrayList<>();
                for (Media item : cart.getItemsOrdered()) {
                    if (item.get_ID() == id) {
                        filterByID.add(item);
                    }
                }
                tblMedia.setItems(FXCollections.observableList(filterByID));
            } catch (NumberFormatException e) {
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered())); // Reset to full list
            }
        }
    }

    @FXML
    // Create a pop-up after placing the order
    private void createPopUp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText("Order Placed Successfully!");
        alert.setContentText("Your total is: " + String.format("%.2f $", cart.totalCost()));
        alert.showAndWait();
    }

    // Optionally, set a new cart
    public void setCart(Cart cart2) {
       this.cart = cart2;
    }
}
