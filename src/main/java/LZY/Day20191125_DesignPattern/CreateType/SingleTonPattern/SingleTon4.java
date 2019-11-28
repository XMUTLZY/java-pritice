package LZY.Day20191125_DesignPattern.CreateType.SingleTonPattern;

/**
 * @单例模式 -创建型模式 方法4
 * 双重校验锁(DCL)
 */
public class SingleTon4 {
    private volatile static SingleTon4 singleTon4;
    private SingleTon4() {
    }
    public static SingleTon4 getInstance() {
        if (singleTon4 == null) {
            synchronized (SingleTon4.class) {
                if (singleTon4 == null) {
                    singleTon4 = new SingleTon4();
                }
            }
        }
        return singleTon4;
    }

}
