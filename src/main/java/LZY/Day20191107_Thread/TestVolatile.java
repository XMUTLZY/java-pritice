package LZY.Day20191107_Thread;

/**
 * @Title: 测试volatile关键字的作用
 */
public class TestVolatile {
    /**
     * @Explain: volatile保证变量的可见性，当一个线程对其变量修改会通知另一个线程
     *
     * 实现原理：对于没有volatile修饰的变量，对其进行读写时，每个线程先从内存中拷贝变量到cpu缓存中，
     * 如果计算机有多个cpu，每个线程可能在不同的cpu上进行处理，这意味着变量可能被拷贝到不同的cpu缓存中，
     * 当某个线程上对变量进行修改，其它线程收不到通知
     *
     * 如果加上volatile关键字，即去掉了cpu缓存这个步骤
     */
    public static volatile boolean flag = false;
    public static Person person;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadDemo1());
        Thread thread2 = new Thread(new ThreadDemo2());
        thread1.start();
        Thread.sleep(5000);/**保证线程1比线程2先执行**/
        thread2.start();
    }
    public static class ThreadDemo1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println("I get the flag is " + flag);
                }
                if (person != null) {
                    System.out.println(person.getClass());
                }
            }
        }
    }
    public static class ThreadDemo2 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            flag = true;
            person = new Person();
        }
    }
}

class Person {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
