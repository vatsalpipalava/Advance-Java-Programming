package Practical_5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {

        DatagramSocket ClientSocket = new DatagramSocket();

        byte[] ClientBuff = new byte[1024];

        String str[] = { "Vatsal ", "M ", "Pipalava "};

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(str.length);
            for (String files : str) {
                dos.writeUTF(files);
            }
        byte[] bytes = baos.toByteArray();

        System.out.println("Please Concatenation those Strings:-->");

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(bais);
        int stringsCount = dis.readInt();
        String[] filesList = new String[stringsCount];
        for (int i = 0; i < stringsCount; ++i) {
            filesList[i] = dis.readUTF();
            System.out.println(filesList[i]);
        }

        // String str = "Hello Server";
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket SendPacket = new DatagramPacket(bytes, bytes.length, ip, 6666);
        // System.out.println("Send " + str + " Message to Server");
        ClientSocket.send(SendPacket);

        DatagramPacket ReceivePacket = new DatagramPacket(ClientBuff, 1024);
        ClientSocket.receive(ReceivePacket);
        String str1 = new String(ReceivePacket.getData(), 0, ReceivePacket.getLength());
        System.out.println("Message From Server:-->Concatenation of String:-->" + str1);

        ClientSocket.close();
    }
}
