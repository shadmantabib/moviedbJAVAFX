package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProfitlossController {
    static public long profitloss;

    public Label lbl;

    public void clickHere(ActionEvent actionEvent) {
        lbl.setText(String.valueOf(profitloss));
    }

    public void back(ActionEvent actionEvent)throws Exception {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menubar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }
}

