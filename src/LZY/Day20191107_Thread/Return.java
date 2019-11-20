package LZY.Day20191107_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Return implements Callable {
    public Return(String s) {
    }

    @Override
    public Object call() throws Exception {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(15);// 创建线程池
        List<Future> list = new ArrayList<>();
        for (int i = 0; i<15; i++) {
            Callable callable = new Return(i + "");
            Future future = pool.submit(callable);
            list.add(future);
        }
        // 关闭线程池
        pool.shutdown();
        for (Future future : list) {
            System.out.println(future.get().toString());
        }
        list.forEach(future -> {
            try {
                System.out.println(future.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
