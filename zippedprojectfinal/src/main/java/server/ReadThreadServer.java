package server;

import Movie.Movie;
import com.example.demo3.AddMovieConroller;
import com.example.demo3.Main;
import com.example.demo3.ReadThread;
import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadThreadServer extends Thread {
    NetworkUtil util;
    public static Socket socket;
    public static int id;
    public String user;

    boolean loggedIn = false;
    public static String comp;
    public ReadThreadServer(Socket s) throws IOException {
        util = new NetworkUtil(s);
    }
    @Override
    public void run() {
        while (true) {
            try {
                Object data = util.read();
                String msg = (String) data;
                if(msg.startsWith("login=")) {
                    System.out.println("Login request");
                    String user = msg.split("=")[1];
                    loggedIn = true;
                    this.user = user;
                    StringBuilder sb = new StringBuilder("movie_list=");
                    for(Movie m: Server.movieList) {
                        if(m.getProduction_Company().equalsIgnoreCase(user)) {
                            sb.append(m.getString());
                            sb.append("\n");
                        }
                    }
                    System.out.println(sb.toString());
                    util.write(sb.toString());
                }
//                else if(loggedIn == false) {
//                    util.write("please login to continue");
//                }
                else if(msg.startsWith("transfer")) {
                    System.out.println(msg);
                    var sp = msg.split(",");
                    String title = sp[1];
                    String to = sp[2];
                    System.out.println(title);
                    System.out.println(to);
                    Movie mm = null;
                    for(int i=0;i< Server.movieList.size();i++) {
                        if(Server.movieList.get(i).getTitle().equalsIgnoreCase(title)) {
                            Server.movieList.get(i).setProduction_Company(to);
                            mm =  Server.movieList.get(i);
                        }
                    }

                    for(int i=0;i<Server.threads.size();i++) {
                        if(Server.threads.get(i).user.equalsIgnoreCase(this.user)) {
                            Server.threads.get(i).util.write("-"+title);
                            System.out.println(this.user + "-----");
                        }
                        if(Server.threads.get(i).user.equalsIgnoreCase(to)) {
                            System.out.println(this.user + "++++++++++");
                            Server.threads.get(i).util.write("+"+mm.getString());
                        }
                    }
                }
                else if(msg.startsWith("add=")){
                    String datam = msg.replace("add=", "");
                    String[] lines = datam.split("\n");
                    //Movie added=new Movie();
                   //Movie added=new Movie();
                    for(var line: lines) {
                        String out[] = line.split(",");
                        System.out.println(comp+"ami eikhane");
                        //Main.all_movies.add(new Movie(out[0],Integer.parseInt(out[1]),out[2],Integer.parseInt(out[3]),out[4],Integer.parseInt(out[5]),Integer.parseInt(out[6])));
                         Movie added=new Movie(out[0],Integer.parseInt(out[1]),out[2],Integer.parseInt(out[3]),user,Integer.parseInt(out[5]),Integer.parseInt(out[6]));
                        System.out.println(added.getString());
                        util.write("*"+added.getString());
                    }
                    System.out.println(msg);
                    //AddMovieConroller ob=new AddMovieConroller();
                    //Movie added=new Movie(ob.nT,ob.nRT,ob.nG,ob.nD,comp,ob.nB,ob.nR);

                  // System.out.println(added.getString());
                       // util.write("a"+added.getString());

                }
                System.out.println("Logged in users:");
                for(ReadThreadServer t:Server.threads) {
                    System.out.println(t.user);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
