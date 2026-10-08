package thread;

class MyblockingQueue{
    String[] queue;
    int size=0;
    int start=0;
    int end=0;
    Object obj=new Object();

    public MyblockingQueue(int cap) throws IllegalAccessException {
        if(cap<=0){
            throw new IllegalAccessException("小");

        }
        queue=new String[cap];
    }
    public void put(String n) throws InterruptedException {
        synchronized(obj) {
            while (size == queue.length) {
                obj.wait();

            }
            queue[end] = n;

            if (end+1 >= queue.length) {
                end = 0;
            } else {
                end++;
            }
            size++;
            obj.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized(obj) {
            while (size == 0) {
                obj.wait();

            }
            String str = queue[start];
            if (start+1 >= queue.length) {
                start = 0;
            } else {
                start++;
            }
            size--;
            obj.notify();
            return str;
        }
    }
}

public class Demo25 {
    public static void main(String[] args) throws IllegalAccessException {
        MyblockingQueue blo=new MyblockingQueue(100);
        //生产者
        Thread thread1=new Thread(()->{
            long n=0;
            while(true) {
                try {
                    blo.put(n + "");
                    System.out.println("生产了" + n);
                    n++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread thread2=new Thread(()->{
            while(true) {
                try {
                    String str1 = blo.take();
                    System.out.println("消费了" + str1);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
