package Day20191107_Thread;

/**
 * 多线程学习
 */
public class ThreadStudy {
    public static void main(String[] args) {
        RunableDemo runableDemo1 = new RunableDemo("thread1");
        RunableDemo runableDemo2 = new RunableDemo("thread2");
        runableDemo1.start();
        runableDemo2.start();
        System.out.println("all thread has finished");
    }
}
