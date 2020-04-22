package auction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AuctionController implements Initializable {
    
    private AuctionModel model;
    
    @FXML
    private Pane mainPane;
    @FXML
    private ComboBox<String> cbItems;
    @FXML
    private Button bidButton;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfBid;
    @FXML
    private Label currentBid;
    @FXML
    private Pane imagePane;
    @FXML
    private ImageView imageView;
    @FXML
    private Label labelName;
    @FXML
    private Label labelBidAmount;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        String name = tfName.getText();
        String bid = tfBid.getText();
        Double cBid = Double.parseDouble(model.getItemBid(cbItems.getSelectionModel().getSelectedIndex()));
        try {
            Double nBid = Double.parseDouble(bid);
            
            if (event.getSource() == bidButton) {
                
                if (cBid < nBid) {
                    
                    currentBid.setText("New Bid:  " + nBid);
                    model.setBiddersName(cbItems.getSelectionModel().getSelectedIndex(), name);
                    model.setItemBid(cbItems.getSelectionModel().getSelectedIndex(), bid);
                    
                } else if (cBid > nBid) {
                    currentBid.setText("Current Bid:  " + cBid);
                    currentBid.setStyle("-fx-text-fill: red");
                } else {
                    currentBid.setText("Same Bid.. Bid Again");
                    currentBid.setStyle("-fx-text-fill: blue");
                }
            }
        } catch (NumberFormatException e) {
            currentBid.setText("PLACE A VALID NUMBER");
            currentBid.setStyle("-fx-font-size: 22");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        model = new AuctionModel();
        model.readFileItemsAvailable();
        
        for (int i = 0; i < model.getArrayListItemsSize(); i++) {
            cbItems.getItems().add(model.getItemName(i));
        }
        removeNodes();
    }
    
    @FXML
    private void handleComboBoxAction(ActionEvent event) {
        if (event.getSource() == cbItems) {
            int index = cbItems.getSelectionModel().getSelectedIndex();
            cbItems.setId(model.getItemName(index));
            currentBid.setText(model.getItemBid(index));
            
            displayNodes();
            
            try {
                String filename = model.getItemLocation(index);
                Image image = new Image(new FileInputStream(filename));

                //ImageView imageView = new ImageView(image);
                imageView.setImage(image);
                imageView.autosize();

                //imageView.setX(0);
                //imageView.setY(0);
                imagePane.getChildren().add(imageView);
                imagePane.setVisible(true);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AuctionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void displayNodes() {
        bidButton.setVisible(true);
        tfName.setVisible(true);
        tfBid.setVisible(true);
        currentBid.setVisible(true);
        labelName.setVisible(true);
        labelBidAmount.setVisible(true);
    }
    
    public void removeNodes() {
        bidButton.setVisible(false);
        tfName.setVisible(false);
        tfBid.setVisible(false);
        currentBid.setVisible(false);
        labelName.setVisible(false);
        labelBidAmount.setVisible(false);
    }
    
    @FXML
    private void handleComboBoxAction(MouseEvent event) {
    }
}
