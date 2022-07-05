package Dough.Chatpter2;

import java.util.LinkedList;

public class SaleingTickets {
    public static class Ticket{
        int cno;
        public Ticket(int cno){
            this.cno = cno;
        }

        public int getNumber(){
            return cno;
        }
    }

    public static class TicketTask implements Runnable{
        private LinkedList<Ticket>tickets;
        public TicketTask(LinkedList<Ticket>tickets){
            this.tickets = tickets;
        }
        @Override
        public void run() {
            while(!tickets.isEmpty()){
                synchronized(this){
                    Ticket ticket = tickets.pollLast();
                    System.out.println(Thread.currentThread().getId() + "卖出去了第 " + ticket.getNumber());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Curtain extends Thread{
        private int curtainNum;
        public int getCurtainNum(){
            return curtainNum;
        }

        public Curtain(int curtainNum, Runnable runnable){
            super(runnable);
            this.curtainNum = curtainNum;
        }
    }

    public static void main(String[] args) {
        LinkedList<Ticket>list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Ticket(i));
        }

        TicketTask ticketTask = new TicketTask(list);
        new Curtain(1,ticketTask).start();
        new Curtain(2,ticketTask).start();
        new Curtain(3,ticketTask).start();

    }



}
