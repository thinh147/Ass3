package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

//Cung cấp message đầu vào
public class Producer extends Thread {
    private final Buffer prodBuf;
    private final CustomQueue<String> message;

    public Producer(Buffer buf, CustomQueue<String> message) {
        prodBuf = buf;
        this.message = message;
    }

    public void run() {
        try {
            Thread.sleep(500); // sleep for a randomly chosen time
            prodBuf.put(message.dequeue());
        }
        catch (InterruptedException ignored) {
        }
    }
}
