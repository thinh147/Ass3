package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;
import message_buffer_queue.model.SharedData;

public class TransferService {
    public synchronized CustomStack<SharedData> produce(SharedData message){
        CustomStack<SharedData> customStack = new CustomStack<>(10);
        if(customStack.isFull()){
            try{
                this.wait();
            }catch (InterruptedException e){
                System.out.println("Please wait to the notification!!!");
            }
        }
        System.out.println("stack push message: " + message.getMessage());
        customStack.push(message);
        notify();
        return customStack;
    }

    public synchronized void consume(SharedData data){
        CustomQueue<String> message = new CustomQueue<>(10);
        if(message.isEmpty()){
            try{
                this.wait();
            }catch (InterruptedException e){
                System.out.println("Please wait the producer add more messages!!!");
            }
        }
        message.enqueue(data.getMessage());
        System.out.println();
        notify();
    }
}
