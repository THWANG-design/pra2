package Dough.Chapter3;

public class IsInterrupated {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("收到中止通知，线程开始中止了");
                    }
                    else{
                        System.out.println(Thread.currentThread().getId() + " i = " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                    }

                }
        });

        t.start();
        Thread.sleep(1000);
        t.interrupt();
        System.out.println(t.getId() + "中断状态" + t.getState());
    }
}
