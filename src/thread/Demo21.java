package thread;
//要求只能有一个实例
//饿汉式 , 类加载的时候创建实例
class Singleton{
    //加了static , 当前的成员成为类属性 ,  在类对象上的 , 类对象只有一个实例
    private static Singleton instance=new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    //单例模式最关键的要点 , 禁止构造方法被外部使用
    private Singleton(){}

}

public class Demo21 {
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1=s2);

    }
}
