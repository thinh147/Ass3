package message_buffer_queue.common;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;
import message_buffer_queue.model.SharedData;

import java.util.Scanner;

public class ServiceImp implements Service{

    @Override
    public CustomStack<SharedData> getDataForConsume() {
        Scanner sc = new Scanner(System.in);
        CustomStack<SharedData> stack = new CustomStack<>(10);
        if(stack.isFull()) System.out.println("Please wait until all messages in the store push!");

        while(stack.size() > 0){
            SharedData sharedData = new SharedData();
            System.out.println("Input message: ");
            String message = sc.nextLine();
            sharedData.setMessage(message);
            stack.push(sharedData);
        }

        return stack;
    }

    @Override
    public CustomQueue<SharedData> getInformationForProducer() {
        Scanner sc = new Scanner(System.in);
        CustomQueue<SharedData> response = new CustomQueue<>();
        CustomStack<SharedData> stack = getDataForConsume();

        if(stack.isEmpty()) getDataForConsume();
        while (!response.isEmpty()){
            SharedData sharedData = stack.top();
            response.enqueue(sharedData);
        }

        return response;
    }
}
