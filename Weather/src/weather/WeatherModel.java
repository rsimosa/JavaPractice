/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherModel {

    ArrayList<Weather> stateList = new ArrayList();
    ArrayList<Weather> countyList = new ArrayList();

    private static final String BASE_URL = "https://www.ncdc.noaa.gov/cdo-web/api/v2/data?datasetid=GHCND&datatypeid=TMAX&";

    public WeatherModel() {
    }

    public void readFile() {

        try {
            Scanner itemsAvailableFile = new Scanner(new File("counties.csv"));

            while (itemsAvailableFile.hasNext()) {

                String stringRead = itemsAvailableFile.nextLine();
                Scanner parse = new Scanner(stringRead);
                parse.useDelimiter(",");

                String identifier = parse.next();
                String stateCode = parse.next();
                String countyCode = parse.next();
                String name = parse.next();

                if (identifier.equalsIgnoreCase("s")) {
                    stateList.add(new Weather(identifier, stateCode, countyCode, name));
                } else {
                    countyList.add(new Weather(identifier, stateCode, countyCode, name));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex);
        }
    }

    public String getNameState(int index) {
        return stateList.get(index).getName();
    }

    public String getNamesCounty(int index) {
        return countyList.get(index).getName();
    }

    public String getStateCode(int index) {
        return stateList.get(index).getStateCode();
    }

    public String getCountyCode(int index) {
        return countyList.get(index).getCountyCode();
    }

    public void fillComboBox(ComboBox cBox, boolean flag, String stateCode) {

        if (flag == true) {
            for (int i = 0; i < stateList.size(); i++) {
                cBox.getItems().add(getNameState(i));
            }
        } else {
            cBox.getItems().clear();
            for (int i = 0; i < countyList.size(); i++) {
                if (countyList.get(i).getStateCode().equalsIgnoreCase(stateCode)) {
                    cBox.getItems().add(getNamesCounty(i));
                }
            }
        }
    }

    public void populateLineChart(LineChart temperatureLineChart, JSONObject json) {

        try {
            XYChart.Series series = new XYChart.Series();
            JSONArray array = json.getJSONArray("results");

            for (int i = 0; i < array.length(); i++) {
                Double temp = Double.parseDouble(array.getJSONObject(i).getString("value"));
                series.getData().add(new XYChart.Data(i + "", temp));
            }
            temperatureLineChart.getData().addAll(series);

        } catch (JSONException ex) {
            System.out.println(ex);
        }
    }

    public JSONObject readJsonFile(String FIPS, String token, LocalDate startDate) throws JSONException {

        String json = "";

        startDate = startDate.withDayOfMonth(1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        String path = BASE_URL + "limit=" + startDate.lengthOfMonth()
                + "&datatypeid=TMAX"
                + "&locationid=FIPS:" + FIPS
                + "&startdate=" + getDateString(startDate)
                + "&enddate=" + getDateString(endDate)
                + "&units=standard";

        try {
            URL url = new URL(path);
            HttpURLConnection myUrlConnection = (HttpURLConnection) url.openConnection();
            myUrlConnection.setRequestProperty("Token", token);
            myUrlConnection.setRequestMethod("GET");
            myUrlConnection.setRequestProperty("Accept", "application/json");

            if (myUrlConnection.getResponseCode() != 200) {
                return new JSONObject("{\"error\":\"HTTP error "
                        + myUrlConnection.getResponseCode() + "\"}");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    myUrlConnection.getInputStream()));
            String s = null;
            while ((s = br.readLine()) != null) {
                json += s;
            }

            myUrlConnection.disconnect();

        } catch (IOException | JSONException e) {
            return new JSONObject("{\"error\":\""
                    + e.getMessage() + "\"}");
        }

        if (json.equals("{}")) {
            json = "{\"error\":\"empty JSON object\"}";
        }

        System.out.println(json);
        return new JSONObject(json);
    }

    private static String getDateString(LocalDate ld) {
        return ld.getYear() + "-"
                + String.format("%02d", ld.getMonth().getValue()) + "-"
                + String.format("%02d", ld.getDayOfMonth());
    }
}
