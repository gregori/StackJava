import java.util.EmptyStackException;

public class ObjectStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    @Override
    public void push(T data) {
        Node aux = top;
        top = new Node<>(data);
        top.next = aux;
        size++;
    }

    @Override
    public T pop() {
        T data;

        if (isEmpty())
            throw new EmptyStackException();

        data = top.data;
        top = top.next;
        size--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
