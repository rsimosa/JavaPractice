/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccergame;

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
    private Button winnerButton;
    @FXML
    private Label result;
    @FXML
    private Button goalsWonByButton;
    @FXML
    private Button gameScoreButton;
    @FXML
    private TextField tfTeam1Name;
    @FXML
    private TextField tfTeam2Score;
    @FXML
    private TextField tfTeam1Score;
    @FXML
    private TextField tfTeam2Name;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
         try {
            String tf1N = tfTeam1Name.getText();
            String tf2N = tfTeam2Name.getText();
            String tf1S = tfTeam1Score.getText();
            String tf2S = tfTeam2Score.getText();
           
            if (event.getSource() == winnerButton) {
                result.setText(SoccerGameModel.whoWon(tf1N, tf1S, tf2N, tf2S));
            } else if (event.getSource() == gameScoreButton) {
                result.setText(SoccerGameModel.gameScore(tf1S, tf2S));
            } else if (event.getSource() == goalsWonByButton) {
                result.setText(SoccerGameModel.goalsWonBy(tf1S, tf2S));
            }

        } catch (NumberFormatException nfe) {
            result.setText("???");
        }

    }
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}