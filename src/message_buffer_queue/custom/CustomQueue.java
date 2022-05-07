package message_buffer_queue.custom;

import java.util.Arrays;
import java.util.List;

public class CustomQueue<T> {
    protected T[] data;  // Array based Queue.
    protected int head = 0; // Index location of the "front" element.
    // In this tutorial, head starts at index 0. There are alternative implementation method.
    protected int tail;  // Index of the "rear" pointer of queue.
    protected int numberOfElements = 0;   // This keeps track of the number of elements in the queue.

    @SuppressWarnings("unchecked")
    public CustomQueue() {
        data = (T[]) new Object[10]; // if no size given, default is 10
        tail = data.length - 1;     //9 is the last index
    }

    @SuppressWarnings("unchecked")
    public CustomQueue(int givenMaxSize) {
        data = (T[]) new Object[givenMaxSize];
        tail = givenMaxSize - 1; //Whatever size is given by the user, size - 1 to get the last index.
    }
    public boolean isEmpty() {
        return (numberOfElements == 0);
        // This returns true if numberOfElement is 0, which means no Enqueu operation has taken place.
    }

    public boolean isFull() {
        return (numberOfElements == data.length);
        // This returns true if numberOfElement is 10 or the given size, which means no Dequeue operation has taken place.
    }


    public void enqueue(T element) {
        if (!isFull()){
            tail = (tail + 1) % data.length;
            // Note: we are dividing integers, and we want the remainder value not the quotient.
            data[tail] = element;
            numberOfElements++; //It is incremented to count the number elements added to the queue.
        }
    }

    // Efficient implementation
    public T dequeue() {
        if (!isEmpty()) {
            T dequeuedValue = data[head];// save the value before deleting it.
            data[head] = null; //Java's garbage collection will empty memory, if it is set to null
            head = (head + 1) % data.length; // determining the index value before deletion
            numberOfElements--; //Since array's size doesn't change, we keep track of the elements inside the queue.
            return dequeuedValue; // returning the removed value.
        } else {
            return null;
            // throw new IndexOutOfBoundsException("Queue is empty.");
            //alternatively:
            //return null; //Since, we are dealing with objects, you can return a null value if it is empty.
        }
    }

    public int size() {
        return numberOfElements;
    }

    //Check or peek what value is located in front of the queue.
    public T front() {
        if (!isEmpty()) {
            return data[head];
        } else {
            return null;
        }
    }

    @Override
    public String toString(){
        List<T> req = Arrays.asList(data);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<req.size()-1; i++){
            builder.append(req.get(i)).append("->");
        }
        builder.append(req.get(req.size()-1));
        return builder.toString();
    }

}