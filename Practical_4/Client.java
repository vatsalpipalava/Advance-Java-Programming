package Practical_4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception{
        
        DatagramSocket ClientSocket = new DatagramSocket();

        byte[] ClientBuff = new byte[1024];

        byte buffer[] = {10,12,20};

        // String str = "Hello Server";
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket SendPacket = new DatagramPacket(buffer,buffer.length, ip, 6666);
        // System.out.println("Send " + str + " Message to Server");
        ClientSocket.send(SendPacket);

        DatagramPacket ReceivePacket =new DatagramPacket(ClientBuff, 1024);
        ClientSocket.receive(ReceivePacket);
        String str1 = new String(ReceivePacket.getData(),0,ReceivePacket.getLength());
        System.out.println("Message From Server:-> Sum of all numbers is : " + str1);

        ClientSocket.close();
    }
}