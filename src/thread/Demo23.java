package thread;


import java.util.concurrent.*;

public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        //基于数组
        BlockingQueue<String> blockingqueue = new ArrayBlockingQueue<>(100);
        //基于链表
        //BlockingQueue<String> blockingqueue = new LinkedBlockingQueue<>(100);
        //基于堆
        //BlockingQueue<String> blockingqueue = new PriorityBlockingQueue<>;
        blockingqueue.put("aaa");
        String ele=blockingqueue.take();




    }
}