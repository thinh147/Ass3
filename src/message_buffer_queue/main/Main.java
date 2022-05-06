package message_buffer_queue.main;

import message_buffer_queue.common.TransferService;
import message_buffer_queue.model.Consumer;
import message_buffer_queue.model.Producer;

public class Main {
    public static void main(String[] args) {
        TransferService transferService = new TransferService();
        new Producer(transferService);
        new Consumer(transferService);
    }
}
