package com.example.demo3;

import Movie.Person;
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
import java.util.ArrayList;
import java.util.List;

public class SearchMovieController {
    static List<Person> people;
    @FXML
    TextField nameText;
    @FXML
    TableView<Person> table;
    @FXML
    TableColumn<Person,String> nameColumn;
    @FXML
    TableColumn<Person,Integer>ageColumn;

    @FXML
    void initialize(){
        //System.out.println("Tabib");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
    }

    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }

    public void onSearchClick(ActionEvent actionEvent) {
        //System.out.println(nameText.getText());
        List<Person>result=new ArrayList<>();
        for(Person p:people){
            if(p.getName().equalsIgnoreCase(nameText.getText()))result.add(p);
        }
        table.getItems().clear();
        for(Person p:result){
            table.getItems().add(p);
        }
    }
}
