import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private int size;
    private int top;
    private int end;
    private T[] stack;
    private int capacity;

    public ArrayStack(int size) {
        top = -1;
        stack = (T[]) new Object[size];
        capacity = size;
        this.size = 0;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public void push(T data) {
        if (isFull())
            throw new StackOverflowError("Pilha cheia!");

        stack[++top] = data;
        size++;
    }

    @Override
    public T pop() {
        T data;

        if (isEmpty())
            throw new EmptyStackException();

        data = stack[top--];
        size--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int getSize() {
        return size;
    }
}
