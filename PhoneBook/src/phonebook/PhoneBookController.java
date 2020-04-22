/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author NEDL
 */
public class PhoneBookController implements Initializable {

    private PhoneBookModel model;

    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button createButton;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private ListView<String> lvContacts;
    @FXML
    private Label errorLabel;
    @FXML
    private Button searchButton;
    @FXML
    private Button sortButton;
    @FXML
    private TextField tfSearch;
    @FXML
    private RadioButton rbLastName;
    @FXML
    private RadioButton rbName;
    @FXML
    private RadioButton rbPhoneNumber;
    @FXML
    private ToggleGroup sortGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        model = new PhoneBookModel();
        model.readFile();
        model.fillListView(lvContacts);
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {

        errorLabel.setText("");

        if (event.getSource() == lvContacts) {

            String fill = lvContacts.getItems().get(lvContacts.getSelectionModel().getSelectedIndex());

            Scanner parse = new Scanner(fill);
            parse.useDelimiter(" ");

            String lName = parse.next();
            String fName = parse.next();
            String pNumber = parse.next();

            tfLastName.setText(lName);
            tfName.setText(fName);
            tfPhoneNumber.setText(pNumber);
        }

        if (event.getSource() == sortButton) {

            if (rbPhoneNumber.isSelected()) {
                model.sortByPhoneNumber();
                errorLabel.setText("Sorted By PhoneNumber");
                lvContacts.getItems().clear();
                model.fillListView(lvContacts);
                
            } else if (rbName.isSelected()) {
                model.sortByFirstName();
                errorLabel.setText("Sorted By FirstName");
                lvContacts.getItems().clear();
                model.fillListView(lvContacts);
                
            } else {
                model.sortByLastname();
                errorLabel.setText("Sorted By LastName");
                lvContacts.getItems().clear();
                model.fillListView(lvContacts);
            }
        }

        if (event.getSource() == searchButton && tfSearch.getText().isEmpty()) {
            errorLabel.setText("Need to Specify a Search");
            lvContacts.getItems().clear();
            model.fillListView(lvContacts);
        } else if (event.getSource() == searchButton && !tfSearch.getText().isEmpty()) {
            model.getSearch(tfSearch.getText().toLowerCase(), lvContacts);
        }

        if ((tfLastName.getText().isEmpty() || tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty())
                && (event.getSource() == deleteButton || event.getSource() == createButton || event.getSource() == updateButton)) {
            errorLabel.setText("can't be an empty field");
        } else {

            if (event.getSource() == deleteButton) {

                model.removePhoneBookList(tfLastName.getText(), tfName.getText(), tfPhoneNumber.getText());
                lvContacts.getItems().clear();
                model.fillListView(lvContacts);
                model.writeFile();
                errorLabel.setText("Deleted a Contact");
                clearText();

            }

            if (event.getSource() == createButton) {

                model.addPhoneBookList(tfLastName.getText(), tfName.getText(), tfPhoneNumber.getText());
                lvContacts.getItems().add(tfLastName.getText() + " " + tfName.getText() + " " + tfPhoneNumber.getText().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3"));
                model.writeFile();
                errorLabel.setText("Created a new Contact");
                clearText();
            }

            if (event.getSource() == updateButton) {

                model.removePhoneBookList(tfLastName.getText(), tfName.getText(), tfPhoneNumber.getText());
                model.addPhoneBookList(tfLastName.getText(), tfName.getText(), tfPhoneNumber.getText());
                lvContacts.getItems().clear();
                model.fillListView(lvContacts);
                model.writeFile();
                errorLabel.setText("Update Sucessfull");
                clearText();
            }
        }
    }

    private void clearText() {
        tfLastName.setText("");
        tfName.setText("");
        tfPhoneNumber.setText("");
    }
}
