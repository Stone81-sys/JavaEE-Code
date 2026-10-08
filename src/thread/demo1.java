package thread;

class MyThread extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("hello thread");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        t.start();
        while(true){
            System.out.println("hello class");
            //Thread.sleep(1000);
        }

    }
}
