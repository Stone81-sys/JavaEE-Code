package thread;

import java.util.Scanner;

public class Demo8 {
    private static boolean  running=true;
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            while(running){
                System.out.println("hello thread");
                try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
            System.out.println("t线程结束");

        });
        t.start();
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入0退出");
        int i=scanner.nextInt();
        if(i==0){
            running=false;

        }
    }
}
