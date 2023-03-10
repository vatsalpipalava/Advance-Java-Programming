package Practical_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String args[])
    {
        try
        {
            ServerSocket ss = new ServerSocket(5252);
            System.out.println("Server waiting for client");
            Socket client=ss.accept();
            System.out.println("Client Connected");
            BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream ps=new PrintStream(client.getOutputStream());
            Date d=new Date();
                System.out.println(br.readLine() ) ;
            ps.println("Current Time on Server's machine: "+d.toString()) ;//write client
            br.close();
            ps.close();
            client.close();
        }
        catch(IOException ie){}
    }
}
