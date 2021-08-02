package org.zerock.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyInOut {

    public static void main(String[] args) {
        InputStream in=System.in;
        OutputStream out=null;
        try {
            out=new FileOutputStream("c:\\zzz\\test.txt");

            for (int i=0;i<10;i++) {
                int data=in.read();
                out.write(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out!=null) {
                try {
                    out.close();
                } catch (Exception e) {
                }
            }
            if (in!=null) {
                try {
                    in.close();
                } catch (Exception e) {}
            }
        }
    }

}
