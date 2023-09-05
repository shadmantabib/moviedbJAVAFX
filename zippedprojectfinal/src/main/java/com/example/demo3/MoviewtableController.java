package com.example.demo3;

import Movie.Movie;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.net.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
public class MoviewtableController implements Initializable {

    static List<Movie> movieList;
    static public String specmov;
    public WebView webView;
    public ImageView imgtrailer;
    private WebEngine engine;
    /* private Main main;
     private Stage stage;
     private Movie m;*/
    @FXML
    TextField nameText;
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

   /* public void setMain(Main main) {
        this.main = main;
    }*/
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1){
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
        imgtrailer.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\imageTrailer.jpg"));

        engine=webView.getEngine();
        loadPage();
    }
    public void loadPage() {
        engine.load("https://www.youtube.com/results?search_query="+nameText.getText()+" movie trailer");
    }


    /*public void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }*/

    public void onSearchClick(ActionEvent actionEvent)throws Exception {
        //System.out.println(nameText.getText());
        ObservableList<Movie>result= FXCollections.observableArrayList();
        //System.out.println(movieList.size());

        for(Movie p:movieList){
            if(p.getTitle().equalsIgnoreCase(nameText.getText()) && p.getProduction_Company().equalsIgnoreCase(specmov) )result.add(p);
        }
        System.out.println(result.size());
        if(result.size()==0){
            Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("NoMovieFound.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            // mainscenecontroller helloController=fxmlLoader.getController();
            // helloController.setHelloapplication(this);
            //stage.setTitle("SHADMAN TABIB");
            stage.setScene(scene);
        }
        table.getItems().clear();
       /* for(Movie p:result){
            table.getItems().add(p);
        }*/
        table.setItems(result);
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


   /* public void onSearchClick(ActionEvent actionEvent) {

    }*/
}
