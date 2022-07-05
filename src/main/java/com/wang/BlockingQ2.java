package com.wang;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BlockingQ2 {

    private Deque<Integer> queue;
    private int maxCount;
    public List<Integer> list;
    public BlockingQ2(int maxCount){
        this.queue = new LinkedList<>();
        this.maxCount = maxCount;
        list = new ArrayList<>();
    }

    public void put() throws Exception {
        for(int i = 0; i < 10; i++){
            synchronized (queue){
                if(queue.size() == maxCount){
                    queue.wait();
                    System.out.println("队列已满");
                }
                queue.offer(i);
                queue.notifyAll();
            }
        }
    }

    public void get() throws Exception{
        for(int i = 0; i < 10; i++){
            synchronized (queue){
                if(queue.size() == 0){
                    queue.wait();
                    System.out.println("请等待");
                }
                int j = queue.poll();
                list.add(j);
                System.out.println(j);
                queue.notifyAll();
            }
        }
    }

    public void print(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }


    public static void main(String[] args) {
        BlockingQ2 blockingQ2 = new BlockingQ2(2);
        new Thread(){
            public void run() {
                try {
                    blockingQ2.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try{
                    blockingQ2.put();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        blockingQ2.print();


    }
}
