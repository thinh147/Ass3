package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;
import message_buffer_queue.model.SharedData;

public class TransferService {
    public synchronized void produce(CustomQueue<SharedData> message){
        if(message.isFull()){
            try{
                this.wait();
            }catch (InterruptedException e){
                System.out.println("Please wait to the notification!!!");
            }
        }
        System.out.println();
        notify();
    }

    public synchronized void consume(CustomStack<SharedData> data){
        if(data.isEmpty()){
            try{
                this.wait();
            }catch (InterruptedException e){
                System.out.println("Please wait the producer add more messages!!!");
            }
        }
        System.out.println();
        notify();
    }
}
