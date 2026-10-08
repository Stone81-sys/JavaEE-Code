package thread;

public class Demo6 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while(true){
                System.out.println("hello t1");
                try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        },"t1");


        Thread t2=new Thread(()->{
            while(true){
                System.out.println("hello t2");
                try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        },"t2");


        Thread t3=new Thread(()->{
            while(true){
                System.out.println("hello t3");
                try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        },"t3");

        t1.start();
        t2.start();
        t3.start();

        while(true){
            System.out.println("hello main");
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
