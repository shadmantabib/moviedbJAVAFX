package com.example.demo3;

import Movie.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class maxmovenamecontroller {

    static List<Movie> movieList;
    public ChoiceBox choice;
    //static public String specmov;
    /* private Main main;
     private Stage stage;
     private Movie m;*/

    //TextField nameText;
    @FXML
    TableView<Movie> table;
    @FXML
    TableColumn<Movie,String> titleCol;
    @FXML
    TableColumn<Movie,Integer>ryearCol;
    @FXML
    TableColumn<Movie,String>genreCol;

    @FXML
    TableColumn<Movie,Integer>durCol;
    @FXML
    TableColumn<Movie,String>prodCol;
    @FXML
    TableColumn<Movie,Integer>budCol;
    @FXML
    TableColumn<Movie,Integer>revCol;
    @FXML
    void initialize(){
        //System.out.println("Tabib");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        // titleCol.setMinWidth(200);
        ryearCol.setCellValueFactory(new PropertyValueFactory<>("Year_of_Release"));
        //  ryearCol.setMinWidth(200);
        // titleCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        // genreCol.setMinWidth(200);
        durCol.setCellValueFactory(new PropertyValueFactory<>("Running_Time"));
        // durCol.setMinWidth(200);
        prodCol.setCellValueFactory(new PropertyValueFactory<>("Production_Company"));
        // prodCol.setMinWidth(200);
        budCol.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        // budCol.setMinWidth(200);
        revCol.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        // revCol.setMinWidth(200);
        Main.mx = this;
        String prod[] = {"Columbia Pictures","Winkler Films","Twentieth Century Fox Film Corporation","Walt Disney Pictures","Davis-Panzer Productions","A Band Apart","Touchstone Pictures","Pixar Animation Studios","United Artists","Paramount Pictures","Icon Entertainment International","Davis-Films","TriStar Pictures","Regency Enterprises","Lightstorm Entertainment","Lucasfilm","Blue Parrot Productions","Keith Barish Productions","Gramercy Pictures","Act III Communications","American Zoetrope","Walt Disney Productions","Eon Productions","Amblin Entertainment","Gaumont","RKO Radio Pictures","Imagine Entertainment","Stanley Kubrick Productions","Caravan Pictures","New Line Cinema","Morgan Creek Productions","Miramax Films","Orion Pictures","PolyGram Filmed Entertainment","Universal Pictures","Shaw Brothers","Castle Rock Entertainment","Tim Burton Productions","Hawk Films"};
        Arrays.sort(prod);
        for(String s: prod) {
            choice.getItems().add(s);
        }
    }

    public void onLoadclick()throws Exception {
        ObservableList<Movie> q= FXCollections.observableArrayList();
        System.out.println(movieList.size());
        for(Movie p:Main.all_movies){
            q.add(p);
        }

        //table.getItems().clear();
        table.setItems(q);
    }

    public void back(ActionEvent actionEvent)throws Exception {
        String title = table.getSelectionModel().getSelectedItem().getTitle();
        String production_company = (String)choice.getValue();
        Main.netutil.write("transfer,"+title+","+production_company);
//        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("options.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
//        // mainscenecontroller helloController=fxmlLoader.getController();
//        // helloController.setHelloapplication(this);
//        //stage.setTitle("SHADMAN TABIB");
//        stage.setScene(scene);
    }

    public void Exit(ActionEvent actionEvent)throws Exception {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menubar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }
}
