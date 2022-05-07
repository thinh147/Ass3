package message_buffer_queue.model;

import message_buffer_queue.common.TransferService;
import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

public class Producer extends Thread {
    TransferService transferService;
    private static final Scanner sc = new Scanner(System.in);

    public Producer(TransferService transferService) {
        this.transferService = transferService;
        this.start();
    }

    public void run() {
        CustomStack<SharedData> messageStack = new CustomStack<>(10);
        if (messageStack.isFull()) System.out.println("Please wait until all messages in the store push!");

        for (int i = 0; i < 10; i++) {
            SharedData sharedData = new SharedData();
            System.out.println("INPUT MESSAGE: ");
            String message = sc.nextLine();
            sharedData.setMessage(message);
            messageStack.push(sharedData);

            transferService.produce(sharedData);
        }
    }
}
