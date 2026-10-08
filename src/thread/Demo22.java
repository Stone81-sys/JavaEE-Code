package thread;
//懒汉
class SinglentontLazy{
    private volatile static  SinglentontLazy instance=null;

    private static Object ob1=new Object();
    //懒汉模式的关键在于把实例创建的时机推迟了 , 推迟到第一次使用的时候使用
    public static SinglentontLazy getInstance(){
        //这个判断是否要加锁
        if (instance == null) {
            //判断是否创建实例
            synchronized (ob1) {
                if (instance == null) {
                    instance = new SinglentontLazy();
                }
            }
        }
        return instance;
    }
    private SinglentontLazy(){
    }
}

public class Demo22 {
    public static void main(String[] args) {
        SinglentontLazy s1=SinglentontLazy.getInstance();
        SinglentontLazy s2=SinglentontLazy.getInstance();
        System.out.println(s1==s2);
    }
}
