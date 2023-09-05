package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuSceneController {
   @FXML
    public void onBackClick(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
        //stage.show();

    }

    public void onNameClick(ActionEvent actionEvent)throws IOException{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviewtable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
   }

    public void onSearchMovies(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MovieLoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }
}
