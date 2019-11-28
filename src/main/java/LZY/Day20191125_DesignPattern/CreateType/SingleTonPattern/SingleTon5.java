package LZY.Day20191125_DesignPattern.CreateType.SingleTonPattern;

/**
 * @单例模式 方法5
 * 登记式/静态内部类
 */
public class SingleTon5 {
    private static class SingleTemp {
        private static final SingleTon5 singleTon5 = new SingleTon5();
    }
    private SingleTon5() {

    }
    public static SingleTon5 getInstance() {
        return SingleTemp.singleTon5;
    }
}
