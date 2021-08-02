package org.zerock.ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class MyServer {
    
    //bad code close 철저히
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("Ready......");
        while (true) {
            Socket client=serverSocket.accept();
            System.out.println(client);
            OutputStream out=client.getOutputStream();
            File file=new File("c:\\zzz\\aaa.jpg");

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html\r\n\r\n").getBytes());
            InputStream fin=new FileInputStream("c:\\zzz\\aaa.jpg");
            byte[] buffer=new byte[1024*8];
            while (true) {
                int count = fin.read(buffer);
                if (count==-1) break;
                out.write(buffer,0,count);
                // out.write(97);
            }
            //fin.close();
            //out.close();
            //client.close();
        } // end while
    }
}
