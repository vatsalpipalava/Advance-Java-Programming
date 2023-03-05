package Practical_5;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {

        DatagramSocket ServerSocket = new DatagramSocket(6666);

        byte[] ServerBuff = new byte[1024];

        DatagramPacket ReceivePacket = new DatagramPacket(ServerBuff, 1024);
        ServerSocket.receive(ReceivePacket);

        System.out.println("Message From Client:");

        ByteArrayInputStream bais = new ByteArrayInputStream(ServerBuff);
        DataInputStream dis = new DataInputStream(bais);
        int stringsCount = dis.readInt();
        String[] filesList = new String[stringsCount];
        for (int i = 0; i < stringsCount; ++i) {
            filesList[i] = dis.readUTF();
            System.out.println(filesList[i]);
        }

        String result = String.join("", filesList);
        System.out.println("Concatenation of String:-->   " + result);

        // String str2 = "Hello Client";
        InetAddress ip = InetAddress.getByName("localhost");
        int port = ReceivePacket.getPort();
        DatagramPacket SendPacket = new DatagramPacket(result.getBytes(), result.length(), ip, port);
        System.out.println("Send--> " + result + " <--Message to Client");
        ServerSocket.send(SendPacket);

        ServerSocket.close();
    }
}
