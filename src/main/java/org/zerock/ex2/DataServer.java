package org.zerock.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
    private static String[] koreaFood={"김치찌개","된장찌개","청국장","제육볶음","쭈구미볶음"};
    //bad code
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("Ready......");

        while (true) {
            int index=(int)(Math.random()*koreaFood.length);
            Socket socket=serverSocket.accept();
            InputStream in=socket.getInputStream();
            DataInputStream din=new DataInputStream(in);
            OutputStream out=socket.getOutputStream();
            DataOutputStream dos=new DataOutputStream(out);
            String str=din.readUTF();
            System.out.println("CLIENT MSG: "+str);

            String msg="LeeSeungCheol : "+koreaFood[index];
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
