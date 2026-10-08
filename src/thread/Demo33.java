package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo33 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable=new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for (int i = 0; i < 100; i++) {
                    sum+=i;
                }
                return sum;
            }
        };
        //Thread无法接受Callable作为参数 , 需要将Callable包装成FutureTask
        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        Thread thread1=new Thread(futureTask);
        thread1.start();
        //get方法获取call返回值 ,
        System.out.println(futureTask.get());

    }
}
