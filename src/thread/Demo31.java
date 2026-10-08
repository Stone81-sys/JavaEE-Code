package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo31 {
    //private static int count=0;
    private static AtomicInteger count=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                //count++;
                count.getAndIncrement();
            }
        });
        Thread thread2=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                //count++;
                count.getAndIncrement();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count.get());
    }
}
