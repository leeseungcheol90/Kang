package org.zerock.ex1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkClient {
    private static final String[] koreanFood={"김치찌개","설렁탕","된장찌개","청국장","순대국","낙지볶음"};
    private static final String[] japanFood={"돈까스","스시","우동","텐동","라멘","칭기즈칸"};
    private static final String[] chinaFood={"짜장면","짬봉","탕수육","우육면","훠궈","차오판"};
    private static final Map<String,String[]> foodMenu=new HashMap<String,String[]>();
    private static int randNum;
    private static Scanner foodScanner;

    public static void main(String[] args) throws Exception {
        foodMenu.put("한식",koreanFood);
        foodMenu.put("일식",japanFood);
        foodMenu.put("중식",chinaFood);
        foodScanner=new Scanner(System.in);

        Socket socket=new Socket("localhost", 9999);
        System.out.println("Connected......");

        OutputStream out=socket.getOutputStream();
        InputStream in=socket.getInputStream();
        Scanner clientScanner=new Scanner(in);

        while(true) {
            randNum=(int)(Math.random()*5)+1;
            System.out.print("음식의 종류를 적으시오.(한식,일식,중식,'q'이면 종료)>>>");
            String foodKind = foodScanner.nextLine();

            if (foodKind.equalsIgnoreCase("q"))
                break;
            String[] menus = foodMenu.get(foodKind);
            String food = menus[randNum]+"\n";

            out.write(food.getBytes());
            System.out.println(food);
            System.out.println(clientScanner.nextLine());
        }
        out.close();
        socket.close();
        foodScanner.close();
        clientScanner.close();
    }
}
