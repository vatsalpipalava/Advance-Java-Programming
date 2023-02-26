package Practical_2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {

        DatagramSocket ServerSocket = new DatagramSocket(6666);

        byte[] ServerBuff = new byte[1024];

        DatagramPacket ReceivePacket = new DatagramPacket(ServerBuff, 1024);
        ServerSocket.receive(ReceivePacket);
        String str = new String(ReceivePacket.getData(), 0, ReceivePacket.getLength());
        System.out.println("Message From Client:" + str);

        String revStr = "";
        char ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i); // extracts each character
            revStr = ch + revStr; // adds each character in front of the existing string
        }

        InetAddress ip = InetAddress.getByName("localhost");
        int port = ReceivePacket.getPort();
        DatagramPacket SendPacket = new DatagramPacket(revStr.getBytes(), revStr.length(), ip, port);
        System.out.println("Send Reverse String: " + revStr + " to Client");
        ServerSocket.send(SendPacket);

        ServerSocket.close();
    }
}