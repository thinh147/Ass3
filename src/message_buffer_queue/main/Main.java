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
        CustomQueue<String> queueInput = new CustomQueue<>();

        while (queueInput.isEmpty() || queueInput.size() < 10) {
            final long startTime = System.currentTimeMillis();
            Thread prod = new Producer(buf, queueInput);
            Thread cons = new Consumer(buf);


            prod.start();
            prod.join();

            cons.start();
            cons.join();

            final long endTime = System.currentTimeMillis();

            System.out.println(String.format("Total execution time: %s ms", (endTime - startTime)));
        }

//         Wait for the threads to finish
    }
}
