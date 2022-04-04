package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameController {

    @FXML
    private Text Progres;

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

    String A = "fsdfsdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsfsdfsdfsdfd";

    void ShowProgres(int a , int b){

        Progres.setText(a +"/" +b);

    }

    @FXML
    void Button_Klik(ActionEvent event) {


        if (buttonA == event.getSource()){
            System.out.println("A");
            actualQuestion++;
        }

    }

}
