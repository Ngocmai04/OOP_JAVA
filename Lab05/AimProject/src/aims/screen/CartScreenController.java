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
    }

    @FXML
    private void initialize() {
        // Cấu hình các cột của bảng
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        // Liên kết dữ liệu giỏ hàng với TableView
        tblMedia.setItems(FXCollections.observableArrayList(this.cart.getItemsOrdered()));
        
        // Cập nhật tổng chi phí
        lbTotalCost.setText(Double.toString(cart.totalCost()) + " $");

        // Ẩn nút Play và Remove khi không có phương tiện được chọn
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự thay đổi khi chọn phương tiện
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );
    }

    void updateButtonBar(Media media) {
        // Hiển thị nút xóa khi có phương tiện được chọn
        btnRemove.setVisible(true);
        
        // Nếu phương tiện có thể phát, hiển thị nút Play
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Xóa phương tiện được chọn khỏi giỏ hàng
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media.get_Title());
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));  // Cập nhật bảng
            lbTotalCost.setText(Double.toString(cart.totalCost()) + " $");
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Hiển thị thông báo đặt hàng thành công
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Order has been placed successfully!");
        alert.showAndWait();

        // Xóa tất cả phương tiện trong giỏ hàng
       
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));  // Cập nhật bảng
        lbTotalCost.setText("0.0 $");

        // Ẩn các nút
        btnRemove.setVisible(false);
        btnPlay.setVisible(false);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Hiển thị thông báo khi phát phương tiện
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText(null);
            alert.setContentText("Now playing: " + media.get_Title());
            alert.showAndWait();
        }
    }
}
