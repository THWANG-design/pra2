package Dough.Chapter1;

public class myTest2 {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "i = " + i);
                    delay();
                }
                System.out.println("t2线程状态" + t2.getState());
                System.out.println("t1运行结束");
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " k = " + i);
                    delay();

                    if(i == 3){
                        try {
                            System.out.println("t1加入了她");
                            t1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });

        t1.start();
        t2.start();





    }


    public static void delay(){
        double d = 0;
        for (int i = 0; i < 10000; i++) {
            d += (Math.PI + Math.E) / i;
        }
    }
}
