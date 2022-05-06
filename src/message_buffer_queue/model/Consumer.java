package message_buffer_queue.model;

import message_buffer_queue.common.Service;
import message_buffer_queue.common.ServiceImp;
import message_buffer_queue.common.TransferService;
import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.util.Scanner;

public class Consumer extends Thread {
    TransferService transferService;
    Service service = new ServiceImp();
    private static final Scanner sc = new Scanner(System.in);

    public Consumer(TransferService transferService) {
        this.transferService = transferService;
        this.start();
    }

    public void run() {
        transferService.consume(service.getDataForConsume());
    }
}
