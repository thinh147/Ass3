package message_buffer_queue.main;

import message_buffer_queue.common.Buffer;
import message_buffer_queue.common.Consumer;
import message_buffer_queue.common.Producer;
import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer buf = new Buffer();
        Scanner sc = new Scanner(System.in);
        CustomQueue<String> queueInput = new CustomQueue<>();

        while (queueInput.isEmpty() || queueInput.size() < 10) {
            Thread prod = new Producer(buf, queueInput);
            Thread cons = new Consumer(buf);
            System.err.println("Input message data: ");
            String data = sc.nextLine();

            if (data.length() > 250) {
                System.out.println("Please input any string less than 250 characters!! ");
                data = sc.nextLine();
            }

            queueInput.enqueue(data);

            System.err.println("Stack data in present includes: " + queueInput.toString());
            System.err.println("Queue in present includes: " + queueInput.toString());

            prod.start();
            prod.join();

            cons.start();
            cons.join();

            if(data.equals("quit")) break;
        }

//         Wait for the threads to finish
    }
}
