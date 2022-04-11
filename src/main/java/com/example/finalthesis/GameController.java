package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private Text Progres;

    String name;

    int actualQuestion = 1;
    int numQuestion = 10;

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;

  void SetName(String name){

      this.name = name;
  }
    void ShowProgres(int actualQuestion , int numQuestion){

      Progres.setText(actualQuestion +" / "+numQuestion);

    }

    @FXML
    void Button_Klik(ActionEvent event) {


        if (buttonA == event.getSource()){
            System.out.println("A");
            actualQuestion++;
        }

    }

}
