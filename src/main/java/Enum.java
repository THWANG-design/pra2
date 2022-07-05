import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;

public class Enum {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<Integer>();


        stack.offer(1);
        stack.offer(2);
        stack.offer(3);

        System.out.println(stack.poll());
        System.out.println(stack.poll
                ());
        System.out.println(stack.poll());


    }


}
