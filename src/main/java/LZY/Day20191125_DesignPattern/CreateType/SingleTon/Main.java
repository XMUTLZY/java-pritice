package LZY.Day20191125_DesignPattern.CreateType.SingleTon;

public class Main {
    public static void main(String[] args) {
        Thread thread1_1 = new Thread(new ThreadDemo());
        Thread thread1_2 = new Thread(new ThreadDemo());
//        thread1_1.start();
//        thread1_2.start();
        Thread thread2_1 = new Thread(new ThreadDemo());
        Thread thread2_2 = new Thread(new ThreadDemo());
        thread2_1.start();
        thread2_2.start();
    }
}

/**
 * 创建一个线程类，用于测试多线程情况下，对应的单例模式实现方法是否有效
 */
class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(SingleTon1.getInstance().toString());
    }
}
