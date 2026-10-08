package thread;

public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        Thread t1=new Thread(()->{
            synchronized(o1){
                System.out.println("t1在wait之前");
                try {
                    o1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1在wait之后");
            }
        });
        Thread t2 =new Thread(()->{
            synchronized(o1){
                System.out.println("t2在notify之前");
                o1.notify();
                System.out.println("t2在notify之后");
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
