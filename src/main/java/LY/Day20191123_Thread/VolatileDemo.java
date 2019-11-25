package LY.Day20191123_Thread;

/**
 * @Auther: liuyang
 * @Date: 2019/11/23 21:22
 * @Description: volatile是无法保证i++的原子性操作的
 */


public class VolatileDemo {
    static volatile int count = 0;
    public static class vd implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++)
                count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new vd());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(count);
    }
}




