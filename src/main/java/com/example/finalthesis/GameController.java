package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    double procent;
    char answer;

    void nextQuestion() {

        if (Player.actualQuestion - 1 == Player.numQuestion) {

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
                Player.incrementcorrectAnswer();

            }
        }
        if (buttonB == event.getSource()) {
            answer = 'B';
            if (answer == questions.answer[Player.actualQuestion]) {
                Player.incrementcorrectAnswer();

            }
        }
        if (buttonC == event.getSource()) {
            answer = 'C';
            if (answer == questions.answer[Player.actualQuestion]) {
                Player.incrementcorrectAnswer();

            }
        }
        Player.actualQuestion++;
        nextQuestion();
    }

    public void Rezutat(ActionEvent actionEvent) {
        System.out.println(Player.Test);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wyniki");
        alert.setHeaderText("Użytkowniku " +Player.name +" udało ci sie osiągnąc " +Player.correctAnswer +" na " +Player.numQuestion);
        alert.setContentText("Po Kliknieciu Okej Aplikacja zostanie zamknieta ");

        if (alert.showAndWait().get() == ButtonType.OK){
            javafx.application.Platform.exit();
        }
    }
}

