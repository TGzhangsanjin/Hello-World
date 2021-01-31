package singleton;

/**
 * 单例模式 - 懒汉式 lazy loading
 * 在需要时用的时候再初始化一个实例，为了保证线程安全，需要加锁，且需要进行双重非空判断的检查
 * 缺点，由于进行了加锁的处理，所以带来了效率的下降
 * @Author 张三金
 * @Date 2021/1/31 0031 11:26
 * @Company jzb
 * @Version 1.0.0
 */
public class Mgr02 {

    // @TODO 加上volatile 是为了禁止指令重排
    public static volatile Mgr02 INSTANCE;

    private Mgr02() {}

    public static Mgr02 getInstance() {
        /**
         * 双重检查
         * 第一个空值判断去掉不会也是线程安全的，但是会导致所有的线程都会去加锁，在Mgr02实例化后且销毁之前的其它线程再来获取时，
         * 通过第一个非空判断，就可以直接拿到对象，不需要去走里面的锁代码了
         */
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Mgr02.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Mgr02();
                }
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }
}
