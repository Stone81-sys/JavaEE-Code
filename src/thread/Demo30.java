package thread;

import java.util.PriorityQueue;

//任务类 , 表示定时器中要执行的任务类
class MyTask implements Comparable<MyTask>{
    long time;
    Runnable runnable;
    public MyTask(Runnable runnable , long time){
        this.runnable=runnable;
        this.time=System.currentTimeMillis()+time;
    }

    public long getTime(){
        return time;

    }
    public void run(){
        runnable.run();
    }
    public int compareTo(MyTask task){
        return (int)(this.time-task.time);
    }
}

//自定义的定时器
class MyTimer{
    PriorityQueue<MyTask> queue=new PriorityQueue<MyTask>();
    Object object=new Object();
    public MyTimer() throws InterruptedException {


            Thread thread1=new Thread(()->{

                while(true){

                    MyTask task=queue.peek();
                    synchronized (object) {
                        while (task == null) {
                            try {
                                object.wait();
                                task = queue.peek();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        long startTime = System.currentTimeMillis();
                        if (startTime >= task.getTime()) {
                            task.run();
                            queue.poll();
                        } else {
                            try {
                                object.wait(task.getTime() - startTime);
                            } catch (InterruptedException e) {
                                throw new RuntimeException("终止");
                            }
                        }

                    }

                }
            });

           thread1.start();
    }

    public void schedual(Runnable runnable , long time){
        synchronized (object){
            MyTask task=new MyTask(runnable,time);
            queue.add(task);
            object.notify();
        }
    }
}

public class Demo30 {
    public static void main(String[] args) throws InterruptedException {
        MyTimer timer=new MyTimer();
        timer.schedual(()->{
            System.out.println("暂停3000");
        },300);
        timer.schedual(()->{
            System.out.println("暂停1000");
        },100);
        timer.schedual(()->{
            System.out.println("暂停2000");
        },200);


    }
}
