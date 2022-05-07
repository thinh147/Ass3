package message_buffer_queue.model;

import message_buffer_queue.common.TransferService;
import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

public class Consumer extends Thread {
    TransferService transferService;
    private static final Scanner sc = new Scanner(System.in);

    public Consumer(TransferService transferService) {
        this.transferService = transferService;
        this.start();
    }

    public void run() {
        CustomQueue<SharedData> messageQueue = new CustomQueue<>(10);
        if (messageQueue.isEmpty()) System.out.println("Please wait until someone enter some messages into storage!");

        for (int i = 0; i < 10; i++) {
            SharedData sharedData = new SharedData();
            messageQueue.enqueue(sharedData);
            transferService.produce(sharedData);
        }
    }
}
