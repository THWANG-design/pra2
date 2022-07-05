package jvm;

public class stack {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Exception {
        stack stack = new stack();

        try{
            stack.stackLeak();
        }catch (Throwable e){
            System.out.println("StackLength" + stack.stackLength);
            throw e;
        }


    }
}
