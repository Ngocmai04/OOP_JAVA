package src.aims.screen;

import javafx.beans.value.ChangeListener;
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
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        btnRemove.setOnAction(event -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media != null) {
                cart.removeMedia(media);
                updateTotalPrice();
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            }
        });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilterMedia(newValue));

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldMedia, newMedia) -> updateButtonBar(newMedia));

        updateTotalPrice();

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

        btnPlaceOrder.setOnAction(event -> {
            createPopUp();
            cart.getItemsOrdered().clear();
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            updateTotalPrice();
        });
    }

    private void updateTotalPrice() {
        totalPrice.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(media != null);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
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
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            }
        }
    }

    @FXML
    private void createPopUp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText("Order Placed Successfully!");
        alert.setContentText("Your total is: " + String.format("%.2f $", cart.totalCost()));
        alert.showAndWait();
    }
}
