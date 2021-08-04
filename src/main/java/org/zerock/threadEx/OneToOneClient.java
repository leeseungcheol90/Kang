package org.zerock.threadEx;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    public static void main(String[] args) throws Exception {
        Scanner keyScanner=new Scanner(System.in);
        Socket socket=new Socket("localhost",9999);
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        DataInputStream din=new DataInputStream(socket.getInputStream());

        new Thread(()-> {
            while (true) {
                String serverMSg= null;
                try {
                    serverMSg = din.readUTF();
                    System.out.println("서버 : "+serverMSg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } // end while
        }).start();

        while (true) {
            System.out.println("INSERT YOUR MESSAGE");
            String msg=keyScanner.nextLine();
            dos.writeUTF(msg);
        }
    }
}
