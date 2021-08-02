package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneServer {

    //bad code
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        Scanner keyScanner=new Scanner(System.in);
        System.out.println("Ready...");

        Socket client = serverSocket.accept();

        System.out.println("client connected....");

        InputStream in = client.getInputStream();
        OutputStream out=client.getOutputStream();

        Scanner inScanner = new Scanner(in);

        for (int i=0;i<100;i++) {
            String line = inScanner.nextLine();

            System.out.println(line);
            String myMsg = keyScanner.nextLine() + "\n";
            out.write(myMsg.getBytes());
        }

        inScanner.close();
        in.close();
        client.close();
        serverSocket.close();

    }
}
