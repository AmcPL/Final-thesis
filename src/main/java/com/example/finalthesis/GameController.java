package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private Text Progres;

    Quiz Player = new Quiz();
    Questions questions = new Questions();

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;





  void ShowProgres(){

      Progres.setText(Player.actualQuestion +" / "+ Player.numQuestion);

    }

    @FXML
    void Button_Klik(ActionEvent event) {


        if (buttonA == event.getSource()){
            System.out.println(Player.name);
            Player.incrementactualQuestion();
            ShowProgres();
        }

    }

}
