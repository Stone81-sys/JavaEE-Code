package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo24 {
    public static void main(String[] args) {
        BlockingQueue<Long> blockingQueue=new ArrayBlockingQueue<>(100);

        Thread thread1=new Thread(()->{
            long n=0;
            while(true){
                try {
                    blockingQueue.put(n);
                    System.out.println("生产者"+n);
                    n++;
                    //Thread.sleep(100);


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread thread2=new Thread(()->{
            while(true){
                try {
                    Long values=blockingQueue.take();
                    System.out.println("消费者"+values);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



            }
        });
        thread1.start();
        thread2.start();


    }
}
