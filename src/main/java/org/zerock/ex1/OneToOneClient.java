package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1",9999);

        System.out.println("Connected....");
        OutputStream out = socket.getOutputStream();
        InputStream in=socket.getInputStream();
        Scanner keyScanner = new Scanner(System.in);

        for (int i=0;i<100;i++) {
            //문자열을 byte[] 바꿔서 out.write(바이트배열)
            String msg = keyScanner.nextLine() + "\n";

            out.write(msg.getBytes());
            Scanner inScanner = new Scanner(in);
            System.out.println(inScanner.nextLine());
        }
        out.close();
        socket.close();
    }
}
