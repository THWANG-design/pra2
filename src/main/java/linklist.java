import java.util.LinkedList;
import java.util.Stack;

public class linklist {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public linklist() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty()&&stack1.isEmpty();
    }


    public static void main(String[] args) {
        linklist test = new linklist();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.pop();

        test.push(5);
        test.pop();
        test.pop();
        test.pop();
        test.pop();




    }
}
