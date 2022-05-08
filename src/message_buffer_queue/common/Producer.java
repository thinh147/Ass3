package message_buffer_queue.common;
import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

//Cung cấp message đầu vào
public class Producer extends Thread {
    private final Buffer prodBuf;
    private final Scanner sc = new Scanner(System.in);
    private final CustomQueue<String> message;

    public Producer(Buffer buf, CustomQueue<String> message) {
        prodBuf = buf;
        this.message = message;
    }

    public void run() {
            try {
                Thread.sleep((int) (Math.random() * 100)); // sleep for a randomly chosen time

                System.err.println("Input message data: ");
                String data = sc.nextLine();

                if (data.length() > 250) {
                    System.out.println("Please input any string less than 250 characters!! ");
                    data = sc.nextLine();
                }

                message.enqueue(data);

                System.err.println("Queue in present includes: " + message.toString());
                prodBuf.put(message);
                if(message.isFull()) message.dequeue();
            } catch (InterruptedException ignored) {
            }
    }
}
