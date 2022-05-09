package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Button ToRes;


    @FXML
    private Text QuestionText;

    Stage stage;
    Scene scene;
    Parent root;

    char answer;

    void nextQuestion() {

        if (Player.actualQuestion-1 == Player.numQuestion) {

            buttonA.setDisable(true);
            buttonB.setDisable(true);
            buttonC.setDisable(true);
            ToRes.setVisible(true);
        } else {
            ToRes.setVisible(false);
            ShowProgres();

            QuestionText.setText(questions.questions[Player.actualQuestion]);
            buttonA.setText(questions.options[Player.actualQuestion][0]);
            buttonB.setText(questions.options[Player.actualQuestion][1]);
            buttonC.setText(questions.options[Player.actualQuestion][2]);

        }
    }

    void ShowProgres() {

        Progres.setText(Player.actualQuestion + " / " + Player.numQuestion);

    }

    @FXML
    void Button_Klik(ActionEvent event) {


        if (buttonA == event.getSource()) {
            answer = 'A';
            if (answer == questions.answer[Player.actualQuestion]) {
                Player.correctAnswer++;

            }
        }
        if (buttonB == event.getSource()) {
            answer = 'B';
            if (answer == questions.answer[Player.actualQuestion]) {
                Player.correctAnswer++;

            }
        }
        if (buttonC == event.getSource()) {
            answer = 'C';
            if (answer == questions.answer[Player.actualQuestion]) {
                Player.correctAnswer++;
            }
        }
            Player.incrementactualQuestion();
            nextQuestion();
    }


    @FXML
    void ToResults(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Results.fxml"));
        root = loader.load();

        ResultsController resultsController = new ResultsController();


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    void setCSS(){
      buttonA.setStyle("-fx-background-color: white ; -fx-background-radius: 15px;");
      buttonB.setStyle("-fx-background-color: white ; -fx-background-radius: 15px;");
      buttonC.setStyle("-fx-background-color: white ; -fx-background-radius: 15px;");
      ToRes.setStyle("-fx-background-color: white ; -fx-background-radius: 15px;");
    }

}
