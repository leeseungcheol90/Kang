package org.zerock.note;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NoteClient {

    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("localhost",9999);
        Scanner sc=new Scanner(System.in);
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        Gson gson = new Gson();

            while (true) {
                try {
                    System.out.println("어떤 명령을 실행하시겠습니까? (1번 : add, 2번 : list, 9번 : 종료)>>>");
                    int num = Integer.parseInt(sc.nextLine());

                    if (num == 9) {
                        break;
                    } else if (num == 1) {
                        System.out.print("당신은 누구입니까>>>(q는 종료)");
                        String who = sc.nextLine();

                        System.out.println("누구에게 메시지를 보내겠습니까?");
                        String whom = sc.nextLine();

                        System.out.println("메시지 내용은요?");
                        String content = sc.nextLine();

                        NoteDTO noteDTO = NoteDTO.builder().who(who).whom(whom).content(content).build();
                        Command command = Command.builder().cmd("add").noteDTO(noteDTO).build();
                        String msg1 = gson.toJson(command);
                        dos.writeUTF(msg1);
                    } else if (num == 2) {
                        System.out.print("당신은 누구입니까?>>>");
                        String whom = sc.nextLine();
                        NoteDTO noteDTO = NoteDTO.builder().whom(whom).build();
                        Command command = Command.builder().cmd("list").noteDTO(noteDTO).build();
                        String msg1 = gson.toJson(command);
                        dos.writeUTF(msg1);
                    } else {
                        System.out.println("잘 좀 입력해라~");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("형식이 잘못되었다.");
                    continue;
                }
            }
        dos.close();
        sc.close();
    }
}
