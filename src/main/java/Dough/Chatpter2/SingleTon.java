package Dough.Chatpter2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTon {
    private static SingleTon singleTon;

    private SingleTon(){

    }

    public static SingleTon getInstance() throws InterruptedException {
        if(singleTon == null){
            singleTon = new SingleTon();
            System.out.println(Thread.currentThread().getId() + "创建了一个实例");
        }

        return singleTon;
    }

    public void dosomeThing(){

    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SingleTon singleTon = null;
                            try {
                                singleTon = SingleTon.getInstance();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            singleTon.dosomeThing();
                        }
                    }).start();
                }
            });
        }
        pool.shutdown();
    }
}
