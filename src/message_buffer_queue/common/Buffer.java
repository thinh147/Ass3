package message_buffer_queue.common;

import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;


//Bộ đệm, dùng để trung chuyển data.
//Sử dụng queue để store message truyền vào
public class Buffer {
    private final CustomStack<String> stack = new CustomStack<>(10);

    public synchronized void put(String message) throws InterruptedException {
        while (stack.isFull()) {    //wait till the buffer becomes full;
            wait();
        }
        stack.push(message);

        System.out.println("Producer: input data..." + message);
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (stack.isEmpty()) {    //wait till something appears in the buffer
            wait();
        }
        notify();
        if(stack.isFull()) stack.pop();
        System.out.println("Consumer: out put data ..." + stack.top());
    }
}
