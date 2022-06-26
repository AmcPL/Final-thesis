package com.example.finalthesis;

import animatefx.animation.Shake;
import javafx.concurrent.Task;
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
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.onSpinWait;
import static java.lang.Thread.sleep;

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
    void Button_Klik(ActionEvent event) throws InterruptedException {


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
        showCorrentAnswer();
        //nextQuestion();

    }

    private void showCorrentAnswer() throws InterruptedException {
        new animatefx.animation.FlipInX(buttonA).play();
        new animatefx.animation.FlipInX(buttonB).play();
        new animatefx.animation.FlipInX(buttonC).play();

        switch(questions.answer[Player.actualQuestion]){

            case 'A':
                buttonA.setStyle("-fx-background-color: #00ff66;");
                buttonB.setStyle("-fx-background-color: #ff001e;");
                buttonC.setStyle("-fx-background-color: #ff001e;");

                break;

            case 'B':
                buttonB.setStyle("-fx-background-color: #00ff66;");
                buttonA.setStyle("-fx-background-color: #ff001e;");
                buttonC.setStyle("-fx-background-color: #ff001e;");

                break;

            case 'C':
                buttonC.setStyle("-fx-background-color: #00ff66;");
                buttonA.setStyle("-fx-background-color: #ff001e;");
                buttonB.setStyle("-fx-background-color: #ff001e;");

                break;

        }
        delay(2000 , () -> {
                    new animatefx.animation.FlipInX(buttonA).play();
                    new animatefx.animation.FlipInX(buttonB).play();
                    new animatefx.animation.FlipInX(buttonC).play();
                    delay(4000 , () -> {});
                    buttonA.setStyle("-fx-background-color: #ffffff;");
                    buttonB.setStyle("-fx-background-color: #ffffff;");
                    buttonC.setStyle("-fx-background-color: #ffffff;");
                }
                );
        delay(2000 , () -> nextQuestion());

    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    public void Rezutat(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wyniki");
        alert.setHeaderText("Użytkowniku " +Player.name +" udało ci sie osiągnąc " +Player.correctAnswer +" na " +Player.numQuestion);
        alert.setContentText("Po Kliknieciu Okej Aplikacja zostanie zamknieta ");

        if (alert.showAndWait().get() == ButtonType.OK){
            javafx.application.Platform.exit();
        }
    }
}

