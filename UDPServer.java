import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer{
    public static void main(String[] args) throws Exception{

        DatagramSocket ServerSocket = new DatagramSocket(6666);

        byte[] ServerBuff = new byte[1024];

        DatagramPacket ReceivePacket = new DatagramPacket(ServerBuff, 1024);
        ServerSocket.receive(ReceivePacket);
        String str = new String(ReceivePacket.getData(),0,ReceivePacket.getLength());
        System.out.println("Message From Client:" + str);

        String str1 = "Hello Client";
        InetAddress ip = InetAddress.getByName("localhost");
        int port = ReceivePacket.getPort();
        DatagramPacket SendPacket = new DatagramPacket(str1.getBytes(),str1.length(), ip, port);
        System.out.println("Send " + str1 + " Message to Client");
        ServerSocket.send(SendPacket);

        ServerSocket.close();
    }
}