package org.zerock.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy1 {

    //bad code
    public static void main(String[] args) throws Exception {

        URL url=new URL("https://postfiles.pstatic.net/MjAyMTA3MjhfMjE1/MDAxNjI3NDMzMDQxNTgz.uvTtmzSYUUyjF8mcb5qfyiED_XHJMj00Dn0clk7Rs-kg.8fd3I8TQts8b_22pzUB6QMf0lwBXiWEVb4tcO9bRkYYg.JPEG.haeri3201/IMG_9028.JPG?type=w966");
        InputStream in=url.openStream();
        System.out.println(in);
        OutputStream out=new FileOutputStream("C:\\Users\\AIA\\Downloads\\copy.jpg");

        long start=System.currentTimeMillis();
        while (true) {
            int data=in.read();
            if (data==-1) break;
            out.write(data);
        } // end while
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}