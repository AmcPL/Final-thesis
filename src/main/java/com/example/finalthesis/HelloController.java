package com.example.finalthesis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button exit;

    @FXML
    private AnchorPane RootPane;


    Stage stage;
    Scene scene;
    Parent root;


    @FXML
    private Button Play_Game;

    @FXML
    private Button About;


    @FXML
    void Exit_game(ActionEvent event) {

        stage = (Stage) RootPane.getScene().getWindow();
        stage.close();

    }
    @FXML
    void Play_game(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Play_a_game_set_Name.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void About(ActionEvent event) throws IOException {

    Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

}
