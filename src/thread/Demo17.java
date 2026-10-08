package thread;

import java.util.Scanner;

public class Demo17 {
    private static volatile int fal=0;

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while(fal==0){
                //什么都不做
                //System.out.println("哇");
            }
            System.out.println("t1结束");
        });
        Thread t2 =new Thread(()->{
            Scanner scanner= new Scanner(System.in);
            System.out.println("输入");
            fal=scanner.nextInt();
            System.out.println("输入结束");
        });
        t1.start();
        t2.start();

    }
}
