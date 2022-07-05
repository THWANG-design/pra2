package Dough.Chapter1;

public class myTest1 {

    public static void main(String[] args) {
        Object object = new Object();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    while(true){

                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(object){
                    while(true){

                    }
                }
            }
        });

        System.out.println("开始时th1的state" + th1.getState());
        System.out.println("开始时th2的state" + th2.getState());
        System.out.println("main" + Thread.currentThread().getState());

        th1.start();


        try {
            Thread.sleep(1000);
            System.out.println("main" + Thread.currentThread().getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th2.start();

        System.out.println("目前th1的state" + th1.getState());
        System.out.println("目前th2的state" + th2.getState());


    }



}
