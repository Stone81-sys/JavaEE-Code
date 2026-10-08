package thread;

public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Object obj=new Object();
        synchronized(obj){
            System.out.println("wait之前");
            obj.wait();
            System.out.println("wait之后");
        }

    }
}
