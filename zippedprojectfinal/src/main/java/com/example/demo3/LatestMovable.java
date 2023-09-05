package com.example.demo3;

import Movie.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class LatestMovable {

    public static List<Movie> movieList;
    public TableView table;
    public TableColumn titleCol;
    public TableColumn ryearCol;
    public TableColumn genreCol;
    public TableColumn durCol;
    public TableColumn prodCol;
    public TableColumn budCol;
    public TableColumn revCol;
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
    }

    public void onLoadclick() {
        ObservableList<Movie> q= FXCollections.observableArrayList();
        System.out.println(movieList.size());
        for(Movie p:movieList){
            q.add(p);
        }

        //table.getItems().clear();
        table.setItems(q);
    }
    public void backToLogin(ActionEvent actionEvent)throws Exception{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menubar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);

    }
}
