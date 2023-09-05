package server;

import Movie.Movie;
import com.example.demo3.ReadThread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Server extends Thread {
    static ServerSocket serverSocket;
    public static List<Movie> movieList = new ArrayList();
    public static void loadMoviesFromFile() {
        try {
            String INPUT_FILE_NAME = "C:\\Users\\USER\\IdeaProjects\\demo3 (2)\\demo3\\movies.txt";
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String test=new String(line);
                String[] out=test.split(",");
                movieList.add(new Movie(out[0],Integer.parseInt(out[1]),out[2]+" "+out[3]+" "+out[4],Integer.parseInt(out[5]),out[6],Integer.parseInt(out[7]),Integer.parseInt(out[8])));
            }
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    static int id = 0;
    public static ArrayList<ReadThreadServer> threads = new ArrayList<ReadThreadServer>();

    public static void main(String[] args) throws IOException {
        loadMoviesFromFile();

            serverSocket = new ServerSocket(3007);
            while(true) {
                try {
                Socket s = serverSocket.accept();
                System.out.print("Connected to " + id + "\n");
                ReadThreadServer t = new ReadThreadServer(s);
                t.id = id;
                t.socket = s;
                threads.add(t);
                t.start();
                id++;
            }
                catch (Exception e) {
                    e.printStackTrace();
                }
        }

    }

    @Override
    public void run() {

    }
}
