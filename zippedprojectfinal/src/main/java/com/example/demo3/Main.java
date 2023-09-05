package com.example.demo3;

import Movie.Person;
import Movie.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static NetworkUtil netutil;
    public static maxmovenamecontroller mx;
    public static AddMovieConroller ax;

    public static ArrayList<Movie> all_movies = new ArrayList<Movie>();

    // Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        //this.stage=stage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MovieLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            // mainscenecontroller helloController=fxmlLoader.getController();
            // helloController.setHelloapplication(this);
            stage.setTitle("MOVIE DATABASE");
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
   /* public void getToTheUser()throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(peopleapplication.class.getResource("show-user.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 650, 240);
            stage.setTitle("User InfoShow");
            stage.setScene(scene);
            stage.show();
    }
    public void goToMainMenu()throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(peopleapplication.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 240);
        //HelloController helloController=fxmlLoader.getController();
        //helloController.setHelloapplication(this);
        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();

    }*/
    public static void main(String[] args)throws Exception {
        List<Person> people=new ArrayList<Person>();
        people.add(new Person("Tabib VAI",21));
        people.add(new Person("Shadman",23));
        people.add(new Person("abcd",23));

        NameSceneController.people=people;
         List<Movie> movieList = new ArrayList();

       // public static void filework()throws Exception {
            String INPUT_FILE_NAME = "C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\movies.txt";
            // final String OUTPUT_FILE_NAME = "out.txt";

            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));


            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String test=new String(line);
                String[] out=test.split(",");

                movieList.add(new Movie(out[0],Integer.parseInt(out[1]),out[2]+" "+out[3]+" "+out[4],Integer.parseInt(out[5]),out[6],Integer.parseInt(out[7]),Integer.parseInt(out[8])));

            }
            br.close();
        //}
            MoviewtableController.movieList=movieList;
            OptionsController.movieList=movieList;
            launch(args);

    }
}