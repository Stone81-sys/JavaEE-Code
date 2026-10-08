package thread;

public class Demo20 {
    public static void main(String[] args) {
        Object ob1=new Object();
        Thread t1=new Thread(()->{
            synchronized(ob1){
                System.out.println("t1在wait之前");
                try {
                    ob1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1在wait之后");
            }
        });
        Thread t2=new Thread(()->{
            synchronized(ob1){
                System.out.println("t2在wait之前");
                try {
                    ob1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2在wait之后");
            }
        });
        Thread t3=new Thread(()->{
            synchronized(ob1){
                System.out.println("t3在wait之前");
                try {
                    ob1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3在wait之后");
            }
        });
        Thread t4=new Thread(()->{
            synchronized(ob1){
                System.out.println("t4在notify之前");
                ob1.notifyAll();
                System.out.println("t4在notify之后");
            }
        });
        t1.start();
        t2.start();
        t4.start();
        t3.start();


    }
}
