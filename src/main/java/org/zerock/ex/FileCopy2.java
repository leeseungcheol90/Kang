package org.zerock.ex;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy2 {

    //bad copy
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\AIA\\Downloads\\aaa.jpg");
        Path filePath=file.toPath();
        OutputStream out=new FileOutputStream("C:\\Users\\AIA\\Downloads\\bbb.jpg");
        Files.copy(filePath,out);

    }
}
