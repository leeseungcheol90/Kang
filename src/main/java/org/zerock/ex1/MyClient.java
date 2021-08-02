package org.zerock.ex1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class MyClient {

    //bad code
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("include-hoany.asuscomm.com",9999);
        System.out.println(socket);
        InputStream in=socket.getInputStream();

        FileOutputStream fos=new FileOutputStream("c:\\zzz\\bbb.jpg");
        byte[] buffer=new byte[1024*8];
        while (true) {
            int count = in.read(buffer);
            if (count==-1) break;
            fos.write(buffer,0,count);
            // out.write(97);
        }
        fos.close();
        socket.close();
    }
}
