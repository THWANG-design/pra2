package com;

public class synchronzed {

    private Object obj;
    boolean flagA = false;

    public synchronzed(){
        obj = new Object();
    }
    public void printA() throws InterruptedException {

        for(int i = 0; i < 10; i++){
            synchronized (obj){
                if(flagA){
                    obj.wait();
                }
                System.out.println("A");
                flagA = true;
                obj.notify();
            }
        }

    }

    public void printB() throws InterruptedException {
        for(int i = 0; i < 10; i++){
            synchronized (obj){
                if(!flagA){
                    obj.wait();
                }
                System.out.println("B");
                flagA = false;
                obj.notify();
            }
        }
    }


    public static void main(String[] args) {
        synchronzed s = new synchronzed();

        new Thread(){
            public void run(){
                try {
                    s.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try {
                    s.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }



}
