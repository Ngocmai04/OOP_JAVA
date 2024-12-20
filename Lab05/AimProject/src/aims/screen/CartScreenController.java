package src.aims.screen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.aims.cart.Cart;
import src.aims.media.Media;
import src.aims.media.Playable;
import javafx.event.ActionEvent;



public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lbTotalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        // loader.load();
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        lbTotalCost.setText(Double.toString(cart.totalCost()) + " $");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue,
                            Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else
            btnPlay.setVisible(false);

    }

    @FXML
    void btnRemovePressed(ActionEvent event) throws Exception {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media.get_Title());
        lbTotalCost.setText(Double.toString(cart.totalCost()) + " $");
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Complete Order");
        alert.showAndWait();

        // cart.clear();

        tblMedia.setItems(FXCollections.observableArrayList());
        lbTotalCost.setText("0.0 $");

        btnRemove.setVisible(false);
        btnPlay.setVisible(false);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Playing Media");
        alert.setHeaderText(null);
        alert.setContentText("Video is playing.");
        alert.showAndWait();
    }
}