package org.zerock.note;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NoteServer {

    //bad code
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("Ready......");
        Socket socket=serverSocket.accept();
        DataInputStream din=new DataInputStream(socket.getInputStream());
        Gson gson=new Gson();
        NoteService noteService=new NoteService();

        try {
            while (true) {
                String msg = din.readUTF();
                Command tmp = gson.fromJson(msg, Command.class);

                if (tmp.cmd.equalsIgnoreCase("add")) {
                    noteService.add(tmp.getNoteDTO());
                    System.out.println(noteService.map);
                } else if (tmp.cmd.equalsIgnoreCase("list")) {
                    System.out.println(noteService.getList(tmp.noteDTO.getWhom()));
                }
            }
        } catch (IOException ie) {}
        catch (Exception e) {}
    }
}
