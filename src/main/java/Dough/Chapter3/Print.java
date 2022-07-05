package Dough.Chapter3;

public class Print {

    public static class State{
        boolean state;
    }

    public static class printA implements Runnable{
        private State state;

        public printA(State state){
            this.state = state;
        }
        @Override
        public void run() {
            while(true){
                synchronized(state){
                    if(state.state){
                        try {
                            state.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                System.out.println("AA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    state.state = true;

                    state.notify();


                }
            }
        }
    }

    public static class printB implements Runnable{
        private State state;

        public printB(State state){
            this.state = state;
        }
        @Override
        public void run() {
            while (true){
                synchronized (state){
                    if(!state.state){
                        try {
                            state.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                System.out.println("BB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                state.state = false;
                state.notify();

                }
            }
        }
    }

    public static void main(String[] args) {
        State state = new State();
        new Thread(new printA(state)).start();
        new Thread(new printB(state)).start();
    }
}
