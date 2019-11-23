package LY.Day20191123_JVM;

/**
 * @Auther: liuyang
 * @Date: 2019/11/23 13:32
 * @Description:
 *                  VM arguments : -Xms64m 设置内存初始化大小
 *                                 -Xmx256 设置最大能够使用内存大小
 *
 *                  虚拟机为并行计算:
 *                              main函数、JIT编译或垃圾回收都实现为单独的一个线程
 *                              相同:表示两个或者多个任务一起执行
 *                              并发:多个任务交替执行,多个任务之间有可能还是串行的
 *                              并行:真正意义上的"同时执行"
 *
 *                  进程和线程:
 *                              计算机内部每个正在系统上运行的程序都是一个进程,一个进程包含一到多个线程。
 *                              线程是一组指令的集合,或者是程序的特殊段
 *                              线程基本上是轻量级的进程,由操作系统负责多个线程的调度和执行。
 *                              多线程: 再单个程序中同时运行多个线程完成不同的工作
 *
 *                              区别:
 *                                  子进程和父进程有不同的代码和数据空间,而多个线程则共享数据空间,
 *                                  每个线程有自己的执行堆栈和程序计数器为其执行上下文。
 *                                  注:线程在运行中需要使用计算机的内存资源和CPU
 */
public class ShowJVM {

    public static void main(String[] args) {
        new ShowJVM().showJVM();
    }
    public void showJVM(){
        Runtime runtime = Runtime.getRuntime();
        int freeMemory = (int) (runtime.freeMemory()/1024/1024);
        int totalMemory = (int) (runtime.totalMemory()/1024/1024);
        System.out.println("memory info:"+freeMemory+"M/"+totalMemory+"M(free/total)");
    }

}
