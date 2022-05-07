package message_buffer_queue.common;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

public class Producer extends Thread{
    private final Buffer prodBuf;
    private final Scanner sc = new Scanner(System.in);
    private final CustomStack<String> message;

    public Producer (Buffer buf, CustomStack<String> message) {
        prodBuf = buf;
        this.message = message;
    }

    public void run() {
            try {
                Thread.sleep((int) (Math.random() * 100)); // sleep for a randomly chosen time
            } catch (InterruptedException e) {return;}

            try {
                prodBuf.put(message.top());
            } catch (InterruptedException ignored) {
            }
    }
}
