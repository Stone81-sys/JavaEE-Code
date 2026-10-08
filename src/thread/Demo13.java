package thread;


class Couter{
    int count =0;
    synchronized public  void add(){
        count++;
//        synchronized(this){
//           count++;
//        }
    }
}
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Couter c= new Couter();
        Thread t1=new Thread(()->{for (int i = 0; i < 5000; i++) {
            c.add();
        }});
        Thread t2=new Thread(()->{for (int i = 0; i < 5000; i++) {
            c.add();
        }});
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}
