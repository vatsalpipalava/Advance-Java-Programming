package Practical_4;

import java.io.ByteArrayInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception{
        
        DatagramSocket ClientSocket = new DatagramSocket();

        byte[] ClientBuff = new byte[1024];

        byte byteArray[] = {10,12,20};

        System.out.println("Please Sum those Numbers:-->");

        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        for (int i = 0; i < byteArray.length; ++i) {
            int data = bais.read();
            System.out.println(data);
        }

        // String str = "Hello Server";
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket SendPacket = new DatagramPacket(byteArray,byteArray.length, ip, 6666);
        // System.out.println("Send " + str + " Message to Server");
        ClientSocket.send(SendPacket);

        DatagramPacket ReceivePacket =new DatagramPacket(ClientBuff, 1024);
        ClientSocket.receive(ReceivePacket);
        String str1 = new String(ReceivePacket.getData(),0,ReceivePacket.getLength());
        System.out.println("Message From Server:-->Sum of Numbers:--> " + str1);

        ClientSocket.close();
    }
}