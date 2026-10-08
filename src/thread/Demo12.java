package thread;

public class Demo12 {
    private static int count = 0;
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized(lock){
                    count++;
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized(lock){
                count++;
            }}
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
