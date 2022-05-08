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


            prod.start();
            prod.join();

            cons.start();
            cons.join();
        }

//         Wait for the threads to finish
    }
}
