package singleton;

/**
 * 静态内部类的方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * @Author 张三金
 * @Date 2021/1/31 0031 11:51
 * @Company jzb
 * @Version 1.0.0
 */
public class Mgr03 {

    private Mgr03(){}

    private static class Mgr03Holder{
        private final static Mgr03 INSTANCE = new Mgr03();
    }

    public static Mgr03 getInstance() {
        return Mgr03Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
