package edu.realemj.exercises16;
import java.util.*;
public class GenericQueue<E> {
    private ArrayList<E> q = new ArrayList<>();

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void enqueue(E obj) {
        q.add(obj);
    }

    public E dequeue() {
        return q.remove(0);
    }

    public E peek() {
        return q.get(0);
    }

    public String toString() {
        return q.toString();
    }
}
