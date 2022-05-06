package message_buffer_queue.custom;

public class CustomStack<T> {
    protected T[] data;
    protected int topIndexLocation;

    @SuppressWarnings("uncheck")
    public CustomStack(int defaultCapacity) {
        data = (T[]) new Object[defaultCapacity];
        topIndexLocation = -1;
    }

    public boolean isEmpty() {
        return (topIndexLocation == -1);
    }

    public boolean isFull() {
        return (topIndexLocation == data.length - 1);
    }

    public void push(T value) {
        if (!isFull()) {
            topIndexLocation++;
            data[topIndexLocation] = value;
        } else { // This is not necessary, but adding it will help you to see the error, following the requirement
            throw new IndexOutOfBoundsException("Stack is full");
        }

        // Since this is a void method you don't need the else condition
    }

    public void pop() {
        if (!isEmpty()) {
            data[topIndexLocation] = null;
            topIndexLocation--;
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    public T top() {
        if (isEmpty()) return null;
        return data[topIndexLocation];
    }

    public int size() {
        return topIndexLocation + 1;
    }
}
