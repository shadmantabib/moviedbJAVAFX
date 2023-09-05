package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import server.ReadThreadServer;
import util.NetworkUtil;

import java.util.Arrays;

public class MovieLogin {
    public ChoiceBox choice;
    public PasswordField password;
    public ImageView imLARGE;
    public ImageView imPLAY;
    public ImageView imCOMP;
    public ImageView imPASS;
    public ImageView imEYE;
    public Button enter;
    public ImageView imLOGIN;

    @FXML
    void initialize(){
        String prod[] = {"Columbia Pictures","Winkler Films","Twentieth Century Fox Film Corporation","Walt Disney Pictures","Davis-Panzer Productions","A Band Apart","Touchstone Pictures","Pixar Animation Studios","United Artists","Paramount Pictures","Icon Entertainment International","Davis-Films","TriStar Pictures","Regency Enterprises","Lightstorm Entertainment","Lucasfilm","Blue Parrot Productions","Keith Barish Productions","Gramercy Pictures","Act III Communications","American Zoetrope","Walt Disney Productions","Eon Productions","Amblin Entertainment","Gaumont","RKO Radio Pictures","Imagine Entertainment","Stanley Kubrick Productions","Caravan Pictures","New Line Cinema","Morgan Creek Productions","Miramax Films","Orion Pictures","PolyGram Filmed Entertainment","Universal Pictures","Shaw Brothers","Castle Rock Entertainment","Tim Burton Productions","Hawk Films"};
        Arrays.sort(prod);
        for(String s: prod) {
            choice.getItems().add(s);
        }
        imLARGE.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\bb617e1cadf60bdddf848aa586ab6391.jpg"));
        imPLAY.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\unnamed.jpg"));
        imCOMP.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\user-login-icon-set-web-icons-84578964.jpg"));
        imPASS.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\password_64px.png"));
        imEYE.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\index.png"));
        imLOGIN.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\vector-illustration-isolated-white-background-login-button-icon-126999949.jpg"));
    }

    public void onEnterClick(ActionEvent actionEvent)throws Exception {
        if (password.getText().equalsIgnoreCase("abcd")) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menubar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            // mainscenecontroller helloController=fxmlLoader.getController();
            // helloController.setHelloapplication(this);
            //stage.setTitle("SHADMAN TABIB");
            String prodcomp = (String) choice.getValue();
            MoviewtableController.specmov = prodcomp;
            OptionsController.specmov2 = prodcomp;
            AddMovieConroller.specmov3=prodcomp;
            ReadThread.specmov4=prodcomp;
            ReadThreadServer.comp=prodcomp;
            Main.netutil = new NetworkUtil("127.0.0.1", 3007);

            Main.netutil.write("login=" + prodcomp);

            Thread t = new Thread(new ReadThread());
            t.start();

            stage.setScene(scene);
        }
    }
}
