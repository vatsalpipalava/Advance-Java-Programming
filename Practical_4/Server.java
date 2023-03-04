package Practical_4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server{
    public static void main(String[] args) throws Exception{

        DatagramSocket ServerSocket = new DatagramSocket(6666);

        byte[] ServerBuff = new byte[1024];
        int sum=0;
        DatagramPacket ReceivePacket = new DatagramPacket(ServerBuff, 1024);
        ServerSocket.receive(ReceivePacket);

        for (int i = 0; i < ServerBuff.length; i++) {
            sum+=ServerBuff[i];
        }

        System.out.println("The Sum of array is " + sum);

        String string = String.valueOf(sum); 

        // String str = new String(ReceivePacket.getData(),0,ReceivePacket.getLength());
        // System.out.println("Message From Client:" + str);

        // String str1 = "Hello Client";
        InetAddress ip = InetAddress.getByName("localhost");
        int port = ReceivePacket.getPort();
        DatagramPacket SendPacket = new DatagramPacket(string.getBytes(),string.length(), ip, port);
        System.out.println("Send-- " + string + " --to Client");
        ServerSocket.send(SendPacket);

        ServerSocket.close();
    }
}
