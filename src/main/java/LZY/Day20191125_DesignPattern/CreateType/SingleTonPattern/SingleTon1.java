package LZY.Day20191125_DesignPattern.CreateType.SingleTonPattern;

/**
 * @单例模式 -创建型模式 方法1
 */
public class SingleTon1 {
    /**
     * 1、懒汉式，线程不安全
     * 在多线程情况下，无法实现单例模式，所以严格意义上来说该方法并不能实现单例
     */
    private static SingleTon1 singleTon1;
    private SingleTon1() {

    }
    public static SingleTon1 getInstance() {
        if (singleTon1 == null) {
            singleTon1 = new SingleTon1();
        }
        return singleTon1;
    }
}
