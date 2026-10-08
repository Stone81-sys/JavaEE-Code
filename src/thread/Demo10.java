package thread;

public class Demo10 {
    private static int result=0;
    public static void main(String[] args) throws InterruptedException {

        Thread t=new Thread(()->{
            for (int i=0; i<=100;i++){
                result+=i;
            }
            System.out.println("t线程执行完毕");
        });
        t.start();
        t.join();

        System.out.println(result);


    }
}
