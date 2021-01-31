package singleton;

/**
 * 单例模式--饿汉式
 * 类加载到内存后就会初始化一个实例，JVM保证线程安全
 * 简单实用，推荐实用
 * 缺点：由于时饿汉式的，因为类加载时就会初始化一个实例，即在不需要实使用的使用也会进行实例的初始化
 * @Author 张三金
 * @Date 2021/1/31 0031 11:19
 * @Company jzb
 * @Version 1.0.0
 */
public class Mgr01 {

    /**
     * 静态属性，类加载时就会初始化一个实例
     */
    private static final Mgr01 INSTANCE = new Mgr01();

    /**
     * 私有构造器方法很重要，确保其它地方不能通过new 的方式初始化一个实例
     */
    private Mgr01() {}

    public static Mgr01 getInstance () {
        return INSTANCE;
    }

    public void businessMethod() {
        System.out.println("这里是业务代码。。。");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Mgr01.getInstance().hashCode());
        }
    }
}
