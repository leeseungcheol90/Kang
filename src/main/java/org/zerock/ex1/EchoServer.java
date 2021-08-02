package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        // 서버 소켓 준비.
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("Ready...");
        // 루프 시작
        while (true) {
            // 연결 accept() Socket
            Socket socket=serverSocket.accept();
            System.out.println(socket.getInetAddress());
            // 클라이언트가 보낸 메시지 읽기
            InputStream in=socket.getInputStream();
            Scanner inScanner=new Scanner(in);
            String msg=inScanner.nextLine();
            System.out.println(msg);
            // 읽은 메시지를 다시 전송
            String sendMsg="SERVERl : "+msg+"\n";
            OutputStream out=socket.getOutputStream();
            out.write(sendMsg.getBytes());
            out.flush();
            // 소켓 연결 종료
            out.close();
            inScanner.close();
            in.close();
            socket.close();
        } // end while

    }
}
