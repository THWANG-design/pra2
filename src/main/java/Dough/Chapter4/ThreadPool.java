package Dough.Chapter4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {
        BlockingQueue<Runnable>bq = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,8,2000, TimeUnit.MILLISECONDS,bq);

        System.out.println("wangtaohan");

        
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + " is Running");
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        System.out.println("线城市线程数为" + pool.getPoolSize());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线城市线程数为" + pool.getPoolSize());

    }

}
