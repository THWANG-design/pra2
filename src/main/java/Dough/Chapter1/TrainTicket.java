package Dough.Chapter1;

public class TrainTicket {


    public static class TicketTask implements Runnable{
        private Integer Ticket = 30;
        @Override
        public void run() {
            while(Ticket> 0){
                synchronized (Ticket){
                    if(Ticket > 0){
                        System.out.println(Thread.currentThread().getId() + "卖出了" + Ticket-- + "张票");

                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        Thread t1 = new Thread(ticketTask);
        Thread t2 = new Thread(ticketTask);
        Thread t3 = new Thread(ticketTask);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("t1:" + t1.getId());
        System.out.println("t2:" + t2.getId());
        System.out.println("t3:" + t3.getId());

    }
}
