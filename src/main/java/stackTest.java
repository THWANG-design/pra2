import java.util.EmptyStackException;
import java.util.Stack;

public class stackTest {
    static void showpush(Stack<Integer>st, int a){
        st.push(a);
        System.out.println("push " + a);
        System.out.println("Stack " + st);
    }

    static void showpop(Stack<Integer>st){
        System.out.println("pop ->");
        int a = (int)st.pop();
        System.out.println(a);
        System.out.println("stack " + st);

    }

    public  void main(String[] args) {
        Stack<Integer>st = new Stack<Integer>();
        System.out.println("current Stack : " + st);
        showpush(st, 1);
        showpush(st, 2);

        showpop(st);
        showpop(st);
        showpop(st);

//        try{
//            showpop(st);
//        }catch (EmptyStackException e){
//            System.out.println("Empty satck");
//        }

    }
}
