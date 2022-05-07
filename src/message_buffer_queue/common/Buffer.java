package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;

import java.util.Scanner;

public class Buffer {
    private String messages;
    private final CustomQueue<String> queue = new CustomQueue<>();
    private final Scanner sc = new Scanner(System.in);

    public synchronized void put(String message) throws InterruptedException {
        while (!queue.isEmpty()) {    //wait till the buffer becomes empty
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        messages = message;
        queue.enqueue(message);

        System.err.println("Queue data in present includes: " + queue.toString());
        System.out.println("Producer: input data..." + message);
        notify();
    }

    public synchronized String get() throws InterruptedException {
        while (queue.isEmpty()) {    //wait till something appears in the buffer
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        notify();
        String val = messages;
        StringBuilder builder = new StringBuilder(val);
        queue.dequeue();
        System.out.println("Consumer: out put data (reverse string)..." + builder.reverse());
        return val;
    }
}
