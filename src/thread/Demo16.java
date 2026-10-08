package thread;

public class Demo16 {
    public static void main(String[] args) {
        Object lo1=new Object();
        Object lo2=new Object();
        Thread t1 =new Thread(()->{
            synchronized(lo1){
                System.out.println("t1 获取到 lo1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(lo2){
                    System.out.println("t1 获取到 lo2");
                }
            }
        });
        Thread t2 =new Thread(()->{
            synchronized(lo2){
                System.out.println("t2 获取到 lo2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(lo1){
                    System.out.println("t2 获取到 lo1  ");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
