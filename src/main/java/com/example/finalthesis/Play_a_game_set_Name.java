package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Play_a_game_set_Name {

    @FXML
    private Button Back_to_menu;

    @FXML
    private TextField NameField;

    @FXML
    private Button Play_a_Game;

    String name;
    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    void Back_to_menu(ActionEvent event) throws IOException {

        Parent root = load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void Play_a_game(ActionEvent event) throws IOException {

        if(NameField.getText().length() == 0){
            new animatefx.animation.Shake(NameField).play();
            NameField.setStyle("-fx-border-color: red ; -fx-border-with: 2px ;");

        }
        else {
            name = NameField.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
            root = loader.load();

            GameController gameController = loader.getController();
            gameController.SetName(name);
            gameController.ShowProgres(gameController.actualQuestion, gameController.numQuestion);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
