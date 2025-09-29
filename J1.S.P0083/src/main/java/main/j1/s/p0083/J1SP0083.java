package main.j1.s.p0083;

/**
 *
 * @author DuckHai
 */
public class J1SP0083 {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(5);

        System.out.println(stack.get());

        stack.pop();
        System.out.println(stack.get());
        stack.show();
    }
}
