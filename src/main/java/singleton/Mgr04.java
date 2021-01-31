package singleton;

/**
 * 枚举方式 - 《effective java》作者推荐的方式
 * 1、不仅解决了多线程的问题，同时还可以防止反序列化（枚举时无法序列化和反序列化的）
 * 目前是最完美的方式
 * @Author 张三金
 * @Date 2021/1/31 0031 11:46
 * @Company jzb
 * @Version 1.0.0
 */
public enum Mgr04 {
    INSTANCE;

    public void businessMethod() {
        System.out.println("这里是业务代码。。。");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.INSTANCE.hashCode());
            }).start();
        }
    }
}
