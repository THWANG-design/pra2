package com.wang;

import java.util.*;

public class BlockingQueue {
    private int maxCount;
    private Deque<Integer>blockingQueue;

    public BlockingQueue(int size){
            blockingQueue = new LinkedList<>();
            this.maxCount = size;
    }

    public void put(int m) throws Exception {
            synchronized (blockingQueue) {
                while (blockingQueue.size() == maxCount) {
                    System.out.println("消息队列已满，请等待");
                    blockingQueue.wait();
                }
                blockingQueue.offer(m);
                blockingQueue.notifyAll();
            }
    }

    public int get() throws Exception {
            synchronized (blockingQueue) {
                while (blockingQueue.size() == 0) {
                    System.out.println("请等待");
                    blockingQueue.wait();
                }
                int res = blockingQueue.pollFirst();
                blockingQueue.notifyAll();
                return res;


            }

    }


    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(10);
        List<Integer>list = new ArrayList<>();
        new Thread("h1"){
            public void run(){
                while(true)
                    try {
                        System.out.println(queue.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }.start();

        new Thread(){
            public void run(){
                for(int i = 0; i < 100; i++){
                    try {
                        queue.put(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        for(int i = 0; i < list.size(); i++){
            System.out.println(i);
        }
    }

}
