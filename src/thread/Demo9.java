package thread;

import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            Thread cur=Thread.currentThread();
            while(!cur.isInterrupted()){
                System.out.println("hello thread");
                try {
                    Thread.sleep(100_000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    //e.printStackTrace();
                    break;
                }

            }

        });
        t1.start();
        Scanner scan=new Scanner(System.in);
        System.out.println("输入0退出");
        int n=scan.nextInt();
        if(n==0){
            t1.interrupt();
        }
    }
}
