package thread;

public class Demo32 {
    static int ter=0;
    public static void main(String[] args) throws InterruptedException {

        Thread thread1=new Thread(new Runnable(){
            public void run(){
                int sum=0;
                for (int i = 0; i < 100; i++) {
                    sum+=i;
                }
                ter=sum;
            }

        } );
        thread1.start();
        thread1.join();
        System.out.println(ter);


    }
}
