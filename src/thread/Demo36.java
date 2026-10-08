package thread;

import java.util.concurrent.Semaphore;

public class Demo36 {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(1);

        Thread thread1=new Thread(()->{

            for(int i=0;i<100;i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                semaphore.release();

            }
        });

        Thread thread2=new Thread(()->{

            for(int i=0;i<100;i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                semaphore.release();

            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(count);



    }
}
