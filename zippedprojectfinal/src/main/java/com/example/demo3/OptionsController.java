package com.example.demo3;

import Movie.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptionsController {
    static List<Movie> movieList;
    static String specmov2;
    public  String maxmovname1;
    public ImageView imgsearch;
    public ImageView imgmaxrev;
    public ImageView imglatest;
    public ImageView imgback;
    public ImageView imgtotal;
    public ImageView imgtransfers;
    public ImageView imageall;
    public ImageView imgAdd;

    @FXML
    void initialize(){
        imgsearch.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\iconsearch.png"));
        imgmaxrev.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\iconmaxrev.png" ));
        imglatest.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\iconnewrelease.jpg"));
        imgback.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\iconbacktomain.png"));
        imgtotal.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\icontotalprofit.png"));
        imgtransfers.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\icontransfermovie.png"));
        imageall.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\imagemovieall.jpg"));
        imgAdd.setImage(new Image("C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\src\\main\\java\\Assets\\Images\\imageAddNew.jpg"));
    }
    public void SearchMovieController(ActionEvent actionEvent)throws Exception {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviewtable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        //MoviewtableController.specmov=prodcomp.getText();
        stage.setScene(scene);
    }

    public void onMostRecent(ActionEvent actionEvent) throws Exception{
        List<Integer> number = new ArrayList<Integer>();
        for(var m: Main.all_movies) {
            number.add(m.getYear_of_Release());
        }
        Collections.sort(number);
        Collections.reverse(number);
        List<Movie> result=new ArrayList();

           // Movie s = Main.all_movies.get(0);
            //if (s.Year_of_Release == number.get(0))
        for(var m: Main.all_movies) {
            if(number.get(0)==m.Year_of_Release){
            result.add(m);}
        }

        maxmovenamecontroller.movieList=result;
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("maxmovename.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);

        stage.setScene(scene);
    }

    public void revFind(ActionEvent actionEvent)throws Exception {
        List<Long> number = new ArrayList<Long>();
        for(var m: Main.all_movies) {
            number.add(m.getRevenue());
        }
        Collections.sort(number);
        Collections.reverse(number);
        List<Movie> result=new ArrayList();

        // Movie s = Main.all_movies.get(0);
        //if (s.Year_of_Release == number.get(0))
       // result.add(Main.all_movies.get(0));
       // int searchIndex = -1;
      //  List<Movie> result=new ArrayList();


        // Movie s = Main.all_movies.get(0);
        //if (s.Year_of_Release == number.get(0))
        for(var m: Main.all_movies) {
            if(number.get(0)==m.Revenue){
                result.add(m);}
        }
        System.out.println(result.size());
        RevMaxController.movieList=result;
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("revMax.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        // MoviewtableController.specmov=prodcomp.getText();
        stage.setScene(scene);

    }

    public void onClickLP(ActionEvent actionEvent)throws Exception {

        //final String INPUT_FILE_NAME = "movies.txt";
        //final String OUTPUT_FILE_NAME = "out.txt";

        //BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        List<Long> number = new ArrayList<Long>();
        for(var m: Main.all_movies) {
            number.add(m.getRevenue()-m.getBudget());
        }
        long sum = 0;


        for (int i = 0; i < number.size(); i++) {
            sum = sum + number.get(i);
        }
        ProfitlossController.profitloss=sum;
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("profitloss.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        //MoviewtableController.specmov=prodcomp.getText();
        stage.setScene(scene);
    }

    public void backToMain(ActionEvent actionEvent)throws Exception {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MovieLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        // mainscenecontroller helloController=fxmlLoader.getController();
        // helloController.setHelloapplication(this);
        //stage.setTitle("SHADMAN TABIB");
        stage.setScene(scene);
    }

    public void latestMovie(ActionEvent actionEvent)throws Exception {
        List<Integer> number = new ArrayList<Integer>();
        for(var m: Main.all_movies) {
            number.add(m.getYear_of_Release());
        }
        Collections.sort(number);
        Collections.reverse(number);
        List<Movie> result=new ArrayList();

        // Movie s = Main.all_movies.get(0);
        //if (s.Year_of_Release == number.get(0))
        for(var m: Main.all_movies) {
            if(number.get(0)==m.Year_of_Release){
                result.add(m);}
        }
        LatestMovable.movieList=result;
        maxmovenamecontroller.movieList=result;
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("latestMovable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);

        stage.setScene(scene);

    }

    public void addMovie(ActionEvent actionEvent)throws Exception {
        List<Integer> number = new ArrayList<Integer>();
        for(var m: Main.all_movies) {
            number.add(m.getYear_of_Release());
        }
        Collections.sort(number);
        Collections.reverse(number);
        List<Movie> result=new ArrayList();

        // Movie s = Main.all_movies.get(0);
        //if (s.Year_of_Release == number.get(0))
        for(var m: Main.all_movies) {
            if(number.get(0)==m.Year_of_Release){
                result.add(m);}
        }

        AddMovieConroller.movieList=result;
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);

        stage.setScene(scene);
    }
}
