package thread;

public class Demo7 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("hello t1");
                try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
            System.out.println("t线程结束");
        });
        t1.setDaemon(true);
        t1.start();
        try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        System.out.println("主线程结束");


    }
}
