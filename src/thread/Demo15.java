package thread;

class coun{
    public  static int counter=0;
    synchronized public static void add(){
        counter++;
    }
}


public class Demo15 {

    coun p=new coun();

    public static void main(String[] args) throws InterruptedException {
        Object boj=new Object();
        Thread t1=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized (boj   ){
                    coun.add();
                }
            }
        });
        t1.start();
        t1.join();
        System.out.println(coun.counter);
    }
}
