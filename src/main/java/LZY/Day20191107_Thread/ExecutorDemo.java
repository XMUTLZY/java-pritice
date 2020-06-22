package LZY.Day20191107_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    /**
     *  1、new 关键字  （新建）
     *  2、start()方法 （就绪）
     *  3、run()方法   （运行）
     *  4、阻塞
     *  （1） 其中一个线程使用了同步锁，另一个线程则处于阻塞状态 （同步阻塞） lock->jvm锁池
     *  （2） 线程调用了Thread.sleep()或者.join()方法   （其它阻塞）
     *  （3） 线程调用了.wait()方法   (等待阻塞) wait()方法->等待队列
     *  5、死亡
     *  （1） stop()
     *  （2）
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);  //提交多个任务 并执行
        while (true) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getId());
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
