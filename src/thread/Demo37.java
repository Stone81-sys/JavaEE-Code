package thread;

import java.util.concurrent.CountDownLatch;

public class Demo37 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count=new CountDownLatch(8);
        for (int i = 0; i < 8; i++) {
            int id=i;
            Thread thread1=new Thread(()->{
                System.out.println(id+"开始好");
                try {
                    Thread.sleep(100);
                    System.out.println(id+  "好  了");
                    //保存的计数值-1

                    count.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread1.start();
        }
        //通过await进行等待

        count.await();

    }
}
