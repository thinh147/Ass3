package message_buffer_queue.main;

import message_buffer_queue.common.Buffer;
import message_buffer_queue.common.Consumer;
import message_buffer_queue.common.Producer;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer buf = new Buffer();
        Scanner sc = new Scanner(System.in);
        CustomStack<String> test = new CustomStack<>(10);

        while (test.isEmpty() || test.size() < 10) {
            Thread prod = new Producer(buf, test);
            Thread cons = new Consumer(buf);
            System.err.println("Input message data: ");
            String data = sc.nextLine();
            test.push(data);
            System.err.println("Stack in present includes: " + test.toString());
            prod.start();

            cons.start();
            prod.join();
        }

//         Wait for the threads to finish
    }
}
