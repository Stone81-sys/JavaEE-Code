package thread;

public class Demo14 {
    private static int count =0;
    synchronized private static void add(){
        count++;
//        synchronized(Demo14.class){
//            count++;
//        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                add();
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
