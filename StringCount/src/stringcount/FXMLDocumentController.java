/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcount;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author NEDL
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button CharacterCountButton;
    @FXML
    private Button vowelCountButton;
    @FXML
    private Button UpperCaseButton;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField inputText;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            String op = inputText.getText();
            if (event.getSource() == CharacterCountButton) {
                resultLabel.setText(StringCountModel.characterCount(op));
            } else if (event.getSource() == vowelCountButton) {
                resultLabel.setText(StringCountModel.vowelCount(op));
            } else if (event.getSource() == UpperCaseButton) {
                resultLabel.setText(StringCountModel.uppercaseCount(op));
            }
        } catch (NumberFormatException nfe) {
            inputText.setText("");
            resultLabel.setText("???");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
