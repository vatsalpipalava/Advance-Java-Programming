package Practical_3;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket sr = new ServerSocket(1234);
            Socket s = sr.accept();// establishing the connection.
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            int strLength = str.length();
            String reverseStr = "";
            String strout = "";
            for (int i = (strLength - 1); i >= 0; --i) {
                reverseStr = reverseStr + str.charAt(i);
            }
            if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
                strout = " is a Palindrome String.";
            } else {
                strout = " is not a Palindrome String.";
            }
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(strout);
            dout.flush();
            dout.close();
            sr.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
