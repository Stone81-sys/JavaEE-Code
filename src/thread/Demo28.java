package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//固定线程数目的线程池
class MyThreadPool{
    BlockingQueue<Runnable> blockingQueue=new LinkedBlockingQueue<>();

    public MyThreadPool(int i) throws InterruptedException {

        for (int j = 0; j < i; j++) {
            Thread thread = new Thread(()->{
                while (true) {
                    Runnable runnable = null;
                    try {
                        runnable = blockingQueue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    runnable.run();
                }
            });
            thread.setDaemon(true);
            thread.start();
        }
    }

    //往线程池中添加新的任务
    public void sumbit(Runnable task) throws InterruptedException {
        blockingQueue.put(task);
    }

}

public class Demo28 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool=new MyThreadPool(4);
        Thread ter=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                int id=i;
                try {
                    myThreadPool.sumbit(()->{
                        Thread currentThread=Thread.currentThread();
                        System.out.println(currentThread.getName()+","+id);
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread.sleep(1000);
        ter.start();

    }
}
