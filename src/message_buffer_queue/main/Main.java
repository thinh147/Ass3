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
        CustomQueue<String> test = new CustomQueue<>(10);

        while (test.isEmpty() || test.size() < 10) {
            try {
                Thread prod = new Producer(buf, test);
                Thread cons = new Consumer(buf);
                System.err.println("Input message data: ");
                String data = sc.nextLine();
                if(data.length() > 250) {
                    System.out.println("Please enter a string less than 250 characters! ");
                    data = sc.nextLine();
                }
                if(test.isFull()) test.dequeue();
                test.enqueue(data);
                System.err.println("Queue in present includes: " + test.toString());
                prod.start();
                prod.join();

                cons.start();
                cons.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
