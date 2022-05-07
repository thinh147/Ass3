package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;
import message_buffer_queue.model.SharedData;

public interface Service {
    CustomStack<SharedData> getDataForConsume();
    CustomQueue<SharedData> getInformationForProducer();
}
