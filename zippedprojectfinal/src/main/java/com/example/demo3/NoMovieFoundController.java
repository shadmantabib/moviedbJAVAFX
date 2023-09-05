package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NoMovieFoundController {
    public void backAction(ActionEvent actionEvent)throws Exception {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviewtable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 100, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
       // MoviewtableController.specmov=prodcomp.getText();
        stage.setScene(scene);
    }
}
