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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AddMovieConroller {
    static String specmov3;
    static List<Movie> movieList;
    public TextField newTitle;
    public TextField newRYear;
    public TextField newGenre;
    public TextField newDur;
    public TextField newBudg;
    public TextField newRev;
    public String nT;
    public String nG;
    public int nB;
    public int nR;
    public int nRT;
    public int nD;
    public String np;
    //public TextField newprc;

    @FXML
    TableView<Movie> tables;

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
        Main.ax = this;

    }



    public void onLoadClick()throws Exception {
        ObservableList<Movie> q= FXCollections.observableArrayList();
        System.out.println(movieList.size());
        for(Movie p:Main.all_movies){
            q.add(p);
        }
        System.out.println("sbdhshjfshjdhjsf");
        //table.getItems().clear();
        tables.setItems(q);
        System.out.println(q.size());
       // System.out.println(newTitle.getText());

    }

    public void refreshClick(ActionEvent actionEvent) throws IOException {
        /*nT=newTitle.getText();
        nRT=Integer.parseInt(newRYear.getText());
        nG=newGenre.getText();
        nD=Integer.parseInt(newDur.getText());
        nB=Integer.parseInt(newBudg.getText());
        nR=Integer.parseInt(newRev.getText());*/
       // System.out.println(nRT);
        nT=newTitle.getText();
        nRT=Integer.parseInt(newRYear.getText());
        nG=newGenre.getText();
       // np=newprc.getText();
        nD=Integer.parseInt(newDur.getText());
        nB=Integer.parseInt(newBudg.getText());
        nR=Integer.parseInt(newRev.getText());
        Main.netutil.write("add="+nT+","+nRT+","+nG+","+nD+","+"habijabi"+","+nB+","+nR);
        //System.out.println("xxxxxx");
       // System.out.println(nRT);
    }

    public void returnMenu(ActionEvent actionEvent) throws Exception{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menubar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }
}
