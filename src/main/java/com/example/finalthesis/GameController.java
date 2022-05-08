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

    @FXML
    private Text QuestionText;


void nextQuestion(){

    if(Player.actualQuestion>= Player.numQuestion){
        result();
    }
    else{
        QuestionText.setText(questions.questions[Player.actualQuestion]);
        buttonA.setText(questions.options[Player.actualQuestion][0]);
        buttonB.setText(questions.options[Player.actualQuestion][1]);
        buttonC.setText(questions.options[Player.actualQuestion][2]);
        buttonD.setText(questions.options[Player.actualQuestion][3]);

    }
}
void result(){
System.out.println("Test");
}


  void ShowProgres(){

      Progres.setText(Player.actualQuestion +" / "+ Player.numQuestion);

    }

    @FXML
    void Button_Klik(ActionEvent event) {


        if (buttonA == event.getSource()){
            System.out.println(Player.name);
            Player.incrementactualQuestion();
            ShowProgres();
            nextQuestion();
        }

    }

}
