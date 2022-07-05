package Dough.Chatpter2;

public class FamilyMoney {

    static class Family {
        public double account;
        public Father father;
        public Mother mother;
        public Son son;
        public String name;

        public Family(String name) {
            this.name = name;
        }

        public void setAccount(double money) {
            this.account = money;
        }

        public double getAccount() {
            return this.account;
        }

        public void setFather(Father father){
            this.father = father;
        }

        public void setMother(Mother mother){
            this.mother = mother;
        }

        public void setSon(Son son){
            this.son = son;
        }
    }

    static class Father {
        Family family;
        String name;

        public Father(String name, Family family) {
            this.name = name;
            this.family = family;
        }

        public void earning(int money) {
            synchronized (this.family) {
                double leftMoney = this.family.getAccount();
                System.out.println("父亲" + this.name + "挣钱之前还有" + leftMoney);

                leftMoney += money;
                System.out.println("父亲" + this.name + "挣钱之后还有" + leftMoney);

                this.family.setAccount(leftMoney);

            }
        }

    }

    static class Mother {
        Family family;
        String name;

        public Mother(String name, Family family) {
            this.name = name;
            this.family = family;
        }

        public void shopping(int money) {
            synchronized (this.family) {
                double leftMoney = this.family.getAccount();
                if (leftMoney - money >= 0) {
                    System.out.println("女人" + this.name + "消费前还有" + leftMoney);
                    leftMoney -= money;
                    System.out.println("女人消费后还有" + leftMoney);
                    this.family.setAccount(leftMoney);
                } else {
                    System.out.println("钱不够了别花了坏女人");
                }


            }
        }

    }

    static class Son {
        public Family family;
        private String name;

        public Son(String name, Family family) {
            this.family = family;
            this.name = name;
        }

        public void gamePlaying(int money) {
            synchronized (this.family) {
                double leftMoney = family.getAccount();
                if (leftMoney - money < 0) {
                    System.out.println("家里没钱了别玩了熊孩子");
                } else {
                    System.out.println("玩游戏前还有" + leftMoney);
                    leftMoney -= money;
                    System.out.println("玩游戏后还有" + leftMoney);
                    family.setAccount(leftMoney);
                }
            }
        }
    }

    static class FatherTask implements Runnable {
        private Father father;

        public FatherTask(Father father) {
            this.father = father;
        }

        @Override
        public void run() {
            while (true) {
                father.earning(10);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

        static class MotherTask implements Runnable {
            private Mother mother;

            public MotherTask(Mother mother) {
                this.mother = mother;
            }

            @Override
            public void run() {
                while (true) {
                    mother.shopping(7);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        static class SonTask implements Runnable {
            private Son son;

            public SonTask(Son son) {
                this.son = son;
            }

            @Override
            public void run() {
                while (true) {
                    son.gamePlaying(5);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }




    public static void main(String[] args) {
        Family family = new Family("一家三口");
        Father father = new Father("王", family);
        Mother mother = new Mother("涵", family);
        Son son = new Son("小", family);
        family.setFather(father);
        family.setSon(son);
        family.setMother(mother);

        new Thread(new FatherTask(father)).start();
        new Thread(new MotherTask(mother)).start();
        new Thread(new SonTask(son)).start();

    }
}