package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WorkServer {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("Ready......");
        Socket socket=serverSocket.accept();
        System.out.println("Connected......");
        InputStream in=socket.getInputStream();
        OutputStream out=socket.getOutputStream();
        Scanner serverScanner=new Scanner(in);
        Scanner msgScanner=new Scanner(System.in);
        String statusMsg;

        while (true) {
            String msg = serverScanner.nextLine();

            if (msg.equalsIgnoreCase("q"))
                break;
            System.out.println(msg);
            Thread.sleep(3000);
            statusMsg=msgScanner.nextLine()+"\n";
            out.write(statusMsg.getBytes());
            System.out.println(statusMsg);
        }

        msgScanner.close();
        serverScanner.close();
        in.close();
        socket.close();
    }
}
