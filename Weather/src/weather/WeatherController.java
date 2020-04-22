package weather;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherController implements Initializable {

    private WeatherModel model;
    private final String token = "ZxKMaDDJDALlZrMZIJVPrTcBSxcnGUtQ";
    @FXML
    private Button fetchButton;
    @FXML
    private ComboBox<String> cbState;
    @FXML
    private ComboBox<String> cbCounty;
    @FXML
    private DatePicker dpTemperature;
    @FXML
    private LineChart<?, ?> temperatureLineChart;
    @FXML
    private NumberAxis temperatureAxis;
    @FXML
    private CategoryAxis hourAxis;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (event.getSource() == fetchButton) {

            temperatureLineChart.getData().clear();
            String stateCode = model.getStateCode(cbState.getSelectionModel().getSelectedIndex());
            String countyCode = model.getCountyCode(cbCounty.getSelectionModel().getSelectedIndex());
            String FIPS = stateCode+countyCode;
            
            try {
                JSONObject Json;
                Json = model.readJsonFile(FIPS, token, dpTemperature.getValue());
                model.populateLineChart(temperatureLineChart, Json);
                
            } catch (JSONException ex) {
                System.out.println(ex);
            }
        }

        if (event.getSource() == cbState) {

            String stateCode = model.getStateCode(cbState.getSelectionModel().getSelectedIndex());
            model.fillComboBox(cbCounty, false, stateCode);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new WeatherModel();
        model.readFile();
        model.fillComboBox(cbState, true, null);
    }
}
