package thread;

import java.util.Timer;
import java.util.TimerTask;

public class Demo29 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("hello 1000");
            }

        },1000);

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("hello 3000");
            }

        },3000);

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("hello 2000");
            }

        },2000);

        Thread.sleep(3000);
        timer.cancel();

    }
}
