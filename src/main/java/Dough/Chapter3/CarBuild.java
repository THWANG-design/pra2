package Dough.Chapter3;

import java.util.concurrent.CountDownLatch;

public class CarBuild {

    static class workingTask implements Runnable{
        private CountDownLatch countDownLatch;

        public workingTask(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            int r = (int)(Math.random() * 10);
            try {
                Thread.sleep(r * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getId() + "任务完成");
            countDownLatch.countDown();

        }
    }

    static class waitingTask implements Runnable{
        private CountDownLatch countDownLatch;
        public waitingTask(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("阻塞等待其他任务完成");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务完成了");
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new workingTask(countDownLatch)).start();
        }
        new Thread(new waitingTask(countDownLatch)).start();

    }
}
