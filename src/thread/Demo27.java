package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo27 {
    public static void main(String[] args) {
        //ExecutorService executors=Executors.newCachedThreadPool();
        ExecutorService executors=Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            //这里的id是事实final
            int id=i;
            executors.submit(new Runnable() {
                public void run() {
                    String str=Thread.currentThread().getName();
                    System.out.println("线程执行"+str+","+id);
                }

            });
        }
    }
}
