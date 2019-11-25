package LZY.Day20191107_Thread;

/**
 * @Title: 测试volatile关键字的作用
 */
public class TestVolatile {
    public static Person person = new Person();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo());
        Thread thread2 = new Thread(new ThreadDemo());
        thread1.start();
        thread2.start();
    }
    public static class ThreadDemo implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " " + person.getNumber());
            person.setNumber(2);
        }
    }
}
class Person {
    public int number = 1;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
