package backend;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> data = new ArrayList<>();

    public void push(T item) { data.add(item); }
    public T pop() { return data.remove(data.size() - 1); }
    public T peek() { return data.get(data.size() - 1); }
    public boolean isEmpty() { return data.isEmpty(); }
}
