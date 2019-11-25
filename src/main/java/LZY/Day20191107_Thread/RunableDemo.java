package LZY.Day20191107_Thread;


/**
 * 线程定义类
 */
public class RunableDemo implements Runnable{
    /**
     * 一般建议实现Runable接口来实现线程，因为java不支持多继承，如果我们需要在原来的基础上继承其它父类实现业务逻辑，这时如果继承Thread类不方便
     * setPriorirt用于设置线程的优先级，线程优先级表示线程被执行的概率，并不能表示优先级高的一定比优先级低的先执行
     * setDaemon用于设置线程是否为守护线程，守护线程的最经典案例就是java垃圾回收机制，java虚拟机中如果全是后台进程，没有用户进程，则程序自动退出
     * join()方法用于使主线程进入等待，直到对应的子线程执行完才释放锁，其它子线程不受约束
     * 当调用了join方法的子线程结束后，会自动执行notifyAll()方法唤起主线程继续执行
     * 具体案例请看下面
     */
    private String threadName;

    public RunableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i<20; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);//Thread.currentThread() 获取当前线程
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        Thread thread = new Thread(this, threadName);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if ("thread1".equals(this.threadName)) {
//            thread.setDaemon(true);// 设置线程为守护线程
            thread.setPriority(Thread.MIN_PRIORITY);//设置线程优先级
        } else thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(threadName + "的优先级是：" + thread.getPriority() + ",线程是否为守护线程：" + thread.isDaemon());
        thread.start();
        if ("thread2".equals(this.threadName)) {
            try {
                thread.join();
                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
