package Dough.Chapter3;

public class ChefAndWaitor {

    static public class Order{
        public String Info;
        public String Dno;

        public void setInfo(String info){
            Info = info;
        }

        public void setDno(String Dno){
            this.Dno = Dno;
        }

        public String getInfo(){
            return Info;
        }

        public String getDno(){
            return Dno;
        }
    }

    static class Resturant implements Runnable{
        private Waitor waitor;

        public void setWaitor(Waitor waitor){
            this.waitor = waitor;
        }


        @Override
        public void run() {
            while(true){
                int num = (int) (Math.random() * 5000);

                try {
                    Thread.sleep(num);

                    Order order = new Order();
                    order.setDno("d" + System.currentTimeMillis());
                    order.setInfo("公报给定");

                    synchronized (waitor){
                        waitor.setOrder(order);
                        waitor.setMsgId(1);
                        waitor.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Waitor implements Runnable{
        private Order order;
        private int MsgId;
        private Chef chef;

        public void setOrder(Order order){
            this.order = order;
        }

        public void setChef(Chef chef){
            this.chef = chef;
        }
        public void setMsgId(int MsgId){
            this.MsgId = MsgId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (MsgId == 1) {
                    System.out.println("服务员收到了新的订单" + order.getDno() + " : " + order.getInfo());

                    synchronized (chef){
                        chef.notify();
                        chef.setOrder(order);

                      }
                }

                if(MsgId == 2){
                    System.out.println("订单" + order.getDno() + "已完成");
                }
            }
        }
    }

    static class Chef implements Runnable{
        private Order order;
        private Waitor waitor;


        public void setOrder(Order order){
            this.order = order;
        }

        public void setWaitor(Waitor waitor){
            this.waitor = waitor;
        }
        @Override
        public void run() {
            while (true){
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int Rand = (int) (Math.random() * 5000);
                try {
                    Thread.sleep(Rand);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (waitor){
                    waitor.setMsgId(2);
                    waitor.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Resturant resturant = new Resturant();
        Waitor waitor = new Waitor();
        Chef chef = new Chef();

        waitor.setChef(chef);
        chef.setWaitor(waitor);
        resturant.setWaitor(waitor);

        new Thread(resturant).start();
        new Thread(waitor).start();
        new Thread(chef).start();
        new Thread(chef).start();
        new Thread(chef).start();


    }


}
