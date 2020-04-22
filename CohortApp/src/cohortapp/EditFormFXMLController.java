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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EditFormFXMLController implements Initializable {

    CohortModel model = new CohortModel();
    ArrayList<Students> studentsList = new ArrayList<>();
    private Students student;
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
    private TextField tfState;
    @FXML
    private TextField tfZipCode;
    @FXML
    private TextField tfCompany;
    @FXML
    private TextField tfMentorCode;
    @FXML
    private TextField tfMentorFirstName;
    @FXML
    private TextField tfMentorLastName;
    @FXML
    private TextField tfMentorEmail;
    @FXML
    private TextField tfMentorPhoneNumber;
    @FXML
    private TextField tfCohort;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ComboBox<String> cbStageOne;
    @FXML
    private ComboBox<String> cbStageTwo;
    @FXML
    private ComboBox<String> cbStageThree;
    @FXML
    private ComboBox<String> cbStageFour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void iniData(Students student) {

        this.student = student;

        tfFirstName.setText(student.getName());
        tfLastName.setText(student.getLastName());
        tfEmail.setText(student.getEmail());
        tfPhoneNumber.setText(student.getPhoneNumber());
        tfStreetAddress.setText(student.getAddress().get(0).getStreetName());
        tfCity.setText(student.getAddress().get(0).getCity());
        tfState.setText(student.getAddress().get(0).getState());
        tfZipCode.setText(student.getAddress().get(0).getZipCode());
        tfCompany.setText(student.getCompany());
        //tfMentorCode.setText("VALUE FROM MENTORLIST");
        //tfMentorFirstName.setText("VALUE FROM MENTORLIST");
        //tfMentorLastName.setText("VALUE FROM MENTORLIST");
        //tfMentorEmail.setText("VALUE FROM MENTORLIST");
        //tfMentorPhoneNumber.setText("VALUE FROM MENTORLIST");
        tfCohort.setText(student.getCohort());
        model.fillComboBox(cbStageOne, student);
        model.fillComboBox(cbStageTwo, student);
        model.fillComboBox(cbStageThree, student);
        model.fillComboBox(cbStageFour, student);
    }

    public void iniArrayList(ArrayList<Students> studentsList) {

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

        if (event.getSource() == saveButton) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Save changes");
            alert.setHeaderText("Is all the Information Correct?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {

                studentsList.remove(student);
                JSONObject json = createJSONObject();
                studentsList.add(new Students(json));

                model.changeSceneToMain(event, studentsList);
            }
        }
    }

    private JSONObject createJSONObject() {

        JSONObject json = new JSONObject();

        json.put("cohort", tfCohort.getText());
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
        json.put("mentorCode", tfMentorCode.getText());

        JSONArray stageArray = new JSONArray();
        JSONObject jsonStageOne = new JSONObject();

        jsonStageOne.put("name", "One");
        jsonStageOne.put("status", cbStageOne.getValue());
        stageArray.add(jsonStageOne);

        JSONObject jsonStageTwo = new JSONObject();

        jsonStageTwo.put("name", "Two");
        jsonStageTwo.put("status", cbStageTwo.getValue());
        stageArray.add(jsonStageTwo);

        JSONObject jsonStageThree = new JSONObject();

        jsonStageThree.put("name", "Three");
        jsonStageThree.put("status", cbStageThree.getValue());
        stageArray.add(jsonStageThree);

        JSONObject jsonStageFour = new JSONObject();

        jsonStageFour.put("name", "Four");
        jsonStageFour.put("status", cbStageFour.getValue());
        stageArray.add(jsonStageFour);

        json.put("stages", stageArray);

        return json;
    }
}
