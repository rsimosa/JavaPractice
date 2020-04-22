package cohortapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CohortModel {

    ArrayList<Students> studentsList = new ArrayList<>();
    ArrayList<Mentors> mentorsList = new ArrayList();

    public CohortModel() {
    }

    public void readFile(String fileName) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;

            Iterator iterator = jsonArray.iterator();
            int index = 0;
            while (iterator.hasNext()) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(index);

                if (fileName.equalsIgnoreCase("JsonFinal.json")) {
                    studentsList.add(new Students(jsonObject));
                } else if (fileName.equalsIgnoreCase("mentorInformation.json")) {
                    mentorsList.add(new Mentors(jsonObject));
                }
                iterator.next();
                index++;
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException | ParseException ex) {
        }
    }

    public TableView fillTable(TableView tv, ArrayList<Students> students) {

        String[] nestedCompetences = {"Stage I", "Stage II", "Stage III", "StageIV"};

        TableColumn<Students, String> tcName = new TableColumn<>("First Name");
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tv.getColumns().add(tcName);

        TableColumn<Students, String> tcLastName = new TableColumn<>("Last Name");
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv.getColumns().add(tcLastName);

        TableColumn<Students, String> tcCompany = new TableColumn<>("Company");
        tcCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        tv.getColumns().add(tcCompany);

        TableColumn<Students, String> tcCohort = new TableColumn<>("Cohort");
        tcCohort.setCellValueFactory(new PropertyValueFactory<>("cohort"));
        tv.getColumns().add(tcCohort);

        for (int i = 0; i < nestedCompetences.length; i++) {
            int j = i;
            TableColumn<Students, String> tcStages = new TableColumn<>(nestedCompetences[i]);

            tcStages.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStage().get(j).getstatus()));
            tv.getColumns().add(tcStages);
        }

        if (students == null) {
            studentsList.forEach((student) -> {
                tv.getItems().add(student);
            });
        } else {
            studentsList = students;
            studentsList.forEach((student) -> {
                tv.getItems().add(student);
            });
        }
        return tv;
    }

    public void studentSelectedNullHandleAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Information Failed");
        alert.setHeaderText("MUST SELECT A STUDENT");
        alert.showAndWait();
    }

    public void showStudentInformation(Students studentSelected) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Information");
        alert.setHeaderText(studentSelected.getName() + " " + studentSelected.getLastName());
        alert.setContentText(
                "Phone Number: " + studentSelected.getPhoneNumber() + "\n"
                + "Email: " + studentSelected.getEmail() + "\n"
                + "Street Address: " + studentSelected.getAddress().get(0).getStreetName() + "\n"
                + "City: " + studentSelected.getAddress().get(0).getCity() + " \n"
                + "State: " + studentSelected.getAddress().get(0).getState() + "\n"
                + "Zip Code: " + studentSelected.getAddress().get(0).getZipCode() + "\n"
                + "Company: " + studentSelected.getCompany() + "\n"
                + "Mentor Name: ");
        alert.showAndWait();
    }

    public void writeToFileAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Write To File");
        alert.setHeaderText("Write To File");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            writeJSON();
        }
    }

    public void confirmDeleteMessage(Students studentSelected, TableView tableView) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText("You're About to Delete " + studentSelected.getName() + " " + studentSelected.getLastName());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            studentsList.remove(studentSelected);
            tableView.getItems().remove(studentSelected);
        }
    }

    public void writeJSON() {

        JSONArray root = new JSONArray();
        JSONObject json;

        for (int i = 0; i < studentsList.size(); i++) {

            json = new JSONObject();

            Students student = studentsList.get(i);

            json.put("cohort", "I");
            json.put("name", student.getName());
            json.put("lastName", student.getLastName());
            json.put("phoneNumber", student.getPhoneNumber());
            json.put("email", student.getEmail());

            JSONArray addressArray = new JSONArray();
            JSONObject jsonAddress = new JSONObject();

            jsonAddress.put("streetAddress", student.getAddress().get(0).getStreetName());
            jsonAddress.put("city", student.getAddress().get(0).getCity());
            jsonAddress.put("state", student.getAddress().get(0).getState());
            jsonAddress.put("zipCode", student.getAddress().get(0).getZipCode());
            addressArray.add(jsonAddress);
            json.put("address", addressArray);
            json.put("company", student.getCompany());
            json.put("mentorCode", "not assigned");

            JSONArray stageArray = new JSONArray();
            JSONObject jsonStageOne = new JSONObject();
            jsonStageOne.put("name", "One");
            jsonStageOne.put("status", student.getStage().get(0).getstatus());
            stageArray.add(jsonStageOne);

            JSONObject jsonStageTwo = new JSONObject();
            jsonStageTwo.put("name", "Two");
            jsonStageTwo.put("status", student.getStage().get(1).getstatus());
            stageArray.add(jsonStageTwo);

            JSONObject jsonStageThree = new JSONObject();
            jsonStageThree.put("name", "Three");
            jsonStageThree.put("status", student.getStage().get(2).getstatus());
            stageArray.add(jsonStageThree);

            JSONObject jsonStageFour = new JSONObject();
            jsonStageFour.put("name", "Four");
            jsonStageFour.put("status", student.getStage().get(3).getstatus());
            stageArray.add(jsonStageFour);
            json.put("stages", stageArray);

            root.add(json);
        }

        try (FileWriter file = new FileWriter("JsonFinal.json")) {

            file.write(root.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillComboBox(ComboBox cb, Students student) {

        String[] status = {"Pending", "Approved", "Under Review", "Failed"};
        cb.getItems().addAll(Arrays.asList(status));
        cb.setValue(student.getStage().get(0).getstatus());
    }

    public void changeSceneEdit(ActionEvent event, String controllerName, Students studentSelected) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(controllerName));
        Parent editFormParent = loader.load();

        Scene editFormScene = new Scene(editFormParent);

        EditFormFXMLController editFormController = loader.getController();
        editFormController.iniData(studentSelected);

        editFormController.iniArrayList(studentsList);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(editFormScene);
        window.show();
    }

    public void changeSceneAdd(ActionEvent event, String controllerName, Students studentSelected) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(controllerName));
        Parent addFormParent = loader.load();

        Scene addFormScene = new Scene(addFormParent);

        AddFormFXMLController addFormController = loader.getController();
        addFormController.initializeAdd(studentsList);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addFormScene);
        window.show();
    }

    public void changeSceneToMain(ActionEvent event, ArrayList<Students> studentsList) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLCohortApp.fxml"));
        Parent mainStageParent = loader.load();

        CohortController cohortController = loader.getController();
        cohortController.fromController(studentsList);

        Scene mainStageScene = new Scene(mainStageParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainStageScene);

        window.show();
    }
}
