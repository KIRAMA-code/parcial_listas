package org.example.Model;

import java.util.Objects;

public class Nodo<T> {
    private T data;
    private Nodo<T> next;

    public Nodo(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {

        return data;
    }

    public Nodo<T> getNext() {

        return next;
    }

    public void setNext(Nodo<T> next) {

        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Nodo<?> nodo)) return false;
        return Objects.equals(data, nodo.data) && Objects.equals(next, nodo.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        return "Nodo {" +
                "data = " + data +
                '}';
    }
}
