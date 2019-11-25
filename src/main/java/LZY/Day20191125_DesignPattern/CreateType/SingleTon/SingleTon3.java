package LZY.Day20191125_DesignPattern.CreateType.SingleTon;

/**
 * @单例模式 -创建型模式 方法3
 */
public class SingleTon3 {
    /**
     * 3、饿汉式，线程安全 在类加载时就进行了初始化
     * 缺点：浪费内存
     */
    private static SingleTon3 singleTon3 = new SingleTon3();
    private SingleTon3() {

    }
    public static SingleTon3 getInstance() {
        return singleTon3;
    }
}
