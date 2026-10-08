package thread;

import java.util.concurrent.Semaphore;

public class Demo35 {
    public static void main(String[] args) throws InterruptedException {
        //数字是信号量初始值
        Semaphore semaphore=new Semaphore(4);
        //P操作
        semaphore.acquire();
        System.out.println("P操作");

        semaphore.acquire();
        System.out.println("P操作");

        semaphore.acquire();
        System.out.println("P操作");

        semaphore.acquire();
        System.out.println("P操作");

        semaphore.release();
        System.out.println("V操作");

        semaphore.acquire();
        System.out.println("P操作");





    }
}
