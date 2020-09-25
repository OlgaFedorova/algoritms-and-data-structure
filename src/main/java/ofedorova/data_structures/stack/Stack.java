package ofedorova.data_structures.stack;

import java.util.Arrays;

public class Stack<T> {

    private int size;
    private Object[] stackArray;
    private int top = -1;

    public Stack(int size) {
        this.size = size;
        this.stackArray = new Object[size];
    }

    public Stack() {
        this(16);
    }

    public void push(T element) {
        if (isFull()) {
            resize();
        }
        stackArray[++top] = element;
    }

    public T pop() {
        return (T) stackArray[top--];
    }

    public T peek() {
        return (T) stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    private boolean isFull() {
        return (top == size - 1);
    }

    private void resize() {
        this.size = this.size * 2;
        this.stackArray = Arrays.copyOf(this.stackArray, this.size);
    }
}
