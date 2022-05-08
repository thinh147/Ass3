package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;


//Bộ đệm, dùng để trung chuyển data.
//Sử dụng queue để store message truyền vào
public class Buffer {
    private final CustomStack<String> stack = new CustomStack<>(10);

    public synchronized void put(CustomQueue<String> message) throws InterruptedException {
        while (stack.isFull()) {    //wait till the buffer becomes full;
            wait();
        }
        System.out.println("Producer: input data..." + message.front());
        stack.push(message.dequeue());
        System.err.println("Stack data in present includes: " + stack.toString());

        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (stack.isEmpty()) {    //wait till something appears in the buffer
            wait();
        }
        System.out.println("Consumer: out put data ..." + stack.top());
        notify();
        if (stack.isFull())
            stack.pop();
    }
}
