package cohortapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddFormFXMLController implements Initializable {

    CohortModel model = new CohortModel();
    ArrayList<Students> studentsList = new ArrayList<>();

    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfStreetAddress;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfZipCode;
    @FXML
    private TextField tfCompany;
    @FXML
    private TextField tfState;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button clearButton;
    @FXML
    private TableView tableView;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initializeAdd(ArrayList<Students> studentsList) {

        this.studentsList = studentsList;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == cancelButton) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Cancel");
            alert.setHeaderText("You Are About to Leave This Window");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                model.changeSceneToMain(event, studentsList);
            }
        }

        if (event.getSource() == clearButton) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Clear");
            alert.setHeaderText("are you sure you want to clear all fields?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                tfFirstName.setText("");
                tfLastName.setText("");
                tfEmail.setText("");
                tfPhoneNumber.setText("");
                tfStreetAddress.setText("");
                tfCity.setText("");
                tfZipCode.setText("");
                tfCompany.setText("");
                tfState.setText("");
            }
        }

        if (event.getSource() == saveButton) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Save changes");
            alert.setHeaderText("Is all the Information Correct?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                JSONObject json = createJSONObject();
                studentsList.add(new Students(json));
                model.changeSceneToMain(event, studentsList);
            }
        }
    }

    private JSONObject createJSONObject() {

        JSONObject json = new JSONObject();

        json.put("cohort", "I");
        json.put("name", tfFirstName.getText());
        json.put("lastName", tfLastName.getText());
        json.put("phoneNumber", tfPhoneNumber.getText());
        json.put("email", tfEmail.getText());

        JSONArray addressArray = new JSONArray();
        JSONObject jsonAddress = new JSONObject();

        jsonAddress.put("streetAddress", tfStreetAddress.getText());
        jsonAddress.put("city", tfCity.getText());
        jsonAddress.put("state", tfState.getText());
        jsonAddress.put("zipCode", tfZipCode.getText());
        addressArray.add(jsonAddress);
        json.put("address", addressArray);
        json.put("company", tfCompany.getText());
        json.put("mentorCode", "not assigned");

        JSONArray stageArray = new JSONArray();
        JSONObject jsonStageOne = new JSONObject();
        jsonStageOne.put("name", "One");
        jsonStageOne.put("status", "Pending");
        stageArray.add(jsonStageOne);

        JSONObject jsonStageTwo = new JSONObject();
        jsonStageTwo.put("name", "Two");
        jsonStageTwo.put("status", "Pending");
        stageArray.add(jsonStageTwo);

        JSONObject jsonStageThree = new JSONObject();
        jsonStageThree.put("name", "Three");
        jsonStageThree.put("status", "Pending");
        stageArray.add(jsonStageThree);

        JSONObject jsonStageFour = new JSONObject();
        jsonStageFour.put("name", "Four");
        jsonStageFour.put("status", "Pending");
        stageArray.add(jsonStageFour);
        json.put("stages", stageArray);

        return json;
    }
}
