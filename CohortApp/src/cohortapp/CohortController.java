package cohortapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.ResizeFeatures;
import javafx.scene.control.TextInputDialog;

public class CohortController implements Initializable {

    CohortModel model = new CohortModel();

    TextInputDialog tid = new TextInputDialog();

    ArrayList<Students> fromControllerArrayList = new ArrayList<>();

    @FXML
    private TableView<Students> tableView;
    @FXML
    private Button addButton;
    @FXML
    private Button showInformationButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button generateStudentTable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void fromController(ArrayList<Students> fromControllerArrayList) {

        this.fromControllerArrayList = fromControllerArrayList;
        model.fillTable(tableView, fromControllerArrayList);
        tableView.autosize();
        tableView.setColumnResizePolicy((ResizeFeatures p) -> false);
        generateStudentTable.setDisable(true);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, Exception {

        Students studentSelected = tableView.getSelectionModel().getSelectedItem();

        if (event.getSource() == addButton) {            

            model.changeSceneAdd(event, "AddFormFXML.fxml", studentSelected);
        }

        if (event.getSource() == deleteButton) {
            if (studentSelected == null) {
                model.studentSelectedNullHandleAlert();
            } else {
                model.confirmDeleteMessage(studentSelected, tableView);
            }
        }

        if (event.getSource() == showInformationButton) {
            if (studentSelected == null) {
                model.studentSelectedNullHandleAlert();
            } else {
                model.showStudentInformation(studentSelected);
            }
        }

        if (event.getSource() == modifyButton) {
            if (studentSelected == null) {
                model.studentSelectedNullHandleAlert();
            } else {
                model.changeSceneEdit(event, "EditFormFXML.fxml", studentSelected);
            }
        }

        if (event.getSource() == saveButton) {

            model.writeToFileAlert();
        }

        if (event.getSource() == generateStudentTable) {

            if (!tableView.hasProperties()) {
                //model.readFile("studentInformation.json");
                model.readFile("JsonFinal.json");
                model.fillTable(tableView, null);

                tableView.autosize();

                tableView.setColumnResizePolicy((ResizeFeatures p) -> false);
                //model.readFile("mentorInformation.json");                
            }
            generateStudentTable.setDisable(true);
        }
    }
}
