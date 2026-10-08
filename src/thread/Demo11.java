package thread;

public class Demo11 {
    private static int result=0;
    public static void main(String[] args) {
        Thread mainThead=Thread.currentThread();
        Thread t=new Thread(()->{
            try {
                mainThead.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(result);
        });
        t.start();
        for (int i=0; i<=100; i++){
            result+=i;
        }
        System.out.println("main执行完毕");
    }
}
