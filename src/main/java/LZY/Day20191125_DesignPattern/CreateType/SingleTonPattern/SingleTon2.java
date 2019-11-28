package LZY.Day20191125_DesignPattern.CreateType.SingleTonPattern;

/**
 * @单例模式 -创建型模式 方法2
 */
public class SingleTon2 {
    /**
     * 2、懒汉式，线程安全
     * 缺点：必须加锁synchronized才能保证线程安全，效率低
     */
    private static SingleTon2 singleTon2;
    private SingleTon2() {

    }
    /**
     * 加上synchronized关键字使线程同步
     */
    public static synchronized SingleTon2 getInstance() {
        if (singleTon2 == null) {
            singleTon2 = new SingleTon2();
        }
        return singleTon2;
    }
}
