package com.example.demo3;

import Movie.Movie;
import javafx.application.Platform;
import util.LoginDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadThread implements Runnable{
    public static List<Movie> cl=new ArrayList<>();
    public static List<Movie> ml=new ArrayList<>();
    static public String specmov4;
    public ReadThread() {}

    @Override
    public void run() {
        while(true) {
            try {
                String o = (String)Main.netutil.read();
                if(o.startsWith("movie_list=")) {
                    System.out.println("Movie received");
                    String data = o.replace("movie_list=", "");
                    String[] lines = data.split("\n");
                    for(var line: lines) {
                        String out[] = line.split(",");
                        Main.all_movies.add(new Movie(out[0],Integer.parseInt(out[1]),out[2],Integer.parseInt(out[3]),out[4],Integer.parseInt(out[5]),Integer.parseInt(out[6])));
                    }
                    System.out.println(o);
                }
                else if(o.startsWith("+")) {
                    String s = o.replace("+","");
                    System.out.println(o);
                    String out[] = s.split(",");
                    Main.all_movies.add(new Movie(out[0],Integer.parseInt(out[1]),out[2],Integer.parseInt(out[3]),out[4],Integer.parseInt(out[5]),Integer.parseInt(out[6])));
                    Main.mx.onLoadclick();
                }
                else if(o.startsWith("*")){
                    String p=o.replace("*","");
                    System.out.println(p);
                    String out[]=p.split(",");
                    Main.all_movies.add(new Movie(out[0],Integer.parseInt(out[1]),out[2],Integer.parseInt(out[3]),out[4],Integer.parseInt(out[5]),Integer.parseInt(out[6])));
                    Main.ax.onLoadClick();
                }
                else if(o.startsWith("-")) {
                    String title = o.replace("-","");
                    System.out.println("---------" +title);
                    for(int i=0;i<Main.all_movies.size();i++) {
                        System.out.println(Main.all_movies.get(i).getTitle());
                        if(Main.all_movies.get(i).getTitle().equalsIgnoreCase(title)) {
                            Main.all_movies.remove(i);
                            break;
                        }
                    }
                    Main.mx.onLoadclick();
                }
                else {
                    System.out.println("unknown " + o);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
