package org.zerock.threadEx;

public class Horse extends Thread {
    private String name;
    private int pos;

    public Horse(String name) {
        this.name=name;
        this.pos=0;
    }

    public void run() {
        this.gallop();
    }

    public void gallop() {
        for (int i=0;i<100;i++) {
            int range=(int)(Math.random()*10)+1; // 1부터 10까지 정수
            this.pos+=range;

            int count=this.pos/10;
            synchronized (System.out) {
                for (int j = 0; j < count; j++) {
                    System.out.print(".");
                }
                System.out.println(this.name + ": " + this.pos);
            } try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Horse h1=new Horse("이승철");
        Horse h2=new Horse("조윤형");
        Horse h3=new Horse("이찬호");
        Horse h4=new Horse("정지성");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }
}
