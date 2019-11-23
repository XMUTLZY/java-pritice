package LY.Day20191123_Thread;

/**
 * @Auther: liuyang
 * @Date: 2019/11/23 20:37
 * @Description:    创建线程的方式
 *
 *                 Thread类有一个非常重要的构造方法 public Thread(Runnable target)
 *                 传入一个Runnable实例,在start()方法调用时,新的线程就会执行Runnable.run()方法.
 */
public class CreateThread implements Runnable{
    @Override
    public void run() {
        System.out.println("");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CreateThread());
    }
}
