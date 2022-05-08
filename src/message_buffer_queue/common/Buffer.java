package message_buffer_queue.common;

import message_buffer_queue.custom.CustomStack;

//Bộ đệm, dùng để trung chuyển data.
//Sử dụng queue để store message truyền vào
public class Buffer {
    private String messages;
    private final CustomStack<String> stack = new CustomStack<>(10);

    public synchronized void put(String message) throws InterruptedException {
        while (stack.isFull()) {    //wait till the buffer becomes full;
            wait();
        }

        messages = message;
        stack.push(message);

        System.err.println("Stack data in present includes: " + stack.toString());
        System.out.println("Producer: input data..." + message);
        notify();
    }

    public synchronized String get() throws InterruptedException {
        while (stack.isEmpty()) {    //wait till something appears in the buffer
            wait();
        }
        notify();
        String val = messages;
        stack.pop();
        System.out.println("Consumer: out put data (reverse string)..." + val);
        return val;
    }
}
