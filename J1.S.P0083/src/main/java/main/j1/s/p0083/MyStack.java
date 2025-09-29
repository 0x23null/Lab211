package main.j1.s.p0083;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private final List<T> stackValues = new ArrayList<>();
    
    public void push(T data) {
        stackValues.add(data);
    }
    
    public T pop() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        T data = stackValues.get(stackValues.size() - 1);
        stackValues.remove(stackValues.size() - 1);
        return data;
    }
    
    public T get() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty.");
        }
        return stackValues.get(stackValues.size() - 1);
    }
    
    public void show() {
        for (T i : stackValues) {
            System.out.print(i + " ");
        }
    }
    
}
