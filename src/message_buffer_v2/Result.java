package message_buffer_v2;

import message_buffer_queue.custom.CustomQueue;
import message_buffer_queue.custom.CustomStack;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Result {
    static CustomQueue<String> queue = new CustomQueue<>();
    static CustomStack<String> stack = new CustomStack<>(100000);

    public static String getString(String msg, String err, String input) {
        String string;
        do {
            System.out.println(msg);
            string = input.trim();
            if (string.equals("") || string.length() > 250) {
                System.out.println(err);
            }
        } while (string.equals("") || string.length() > 250);
        return string;
    }

    public static String getInputMessage() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message = getString("Input your message", "Message empty or more than 250 characters", bufferedReader.readLine());
        bufferedReader.close();
        return message;
    }

    public static void buffer(String message){
        int i = 0;
        String[] arr = message.split("");
        while(i< message.length()){
            queue.enqueue(arr[i]);
            arr[i] = null;
            i++;
        }

        while(!queue.isEmpty()) {
            stack.push(queue.front());
            queue.dequeue();
        }
    }
    public static void resolve() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println("Output message: ");
        while (!stack.isEmpty()){
            bufferedWriter.write(stack.top() + "-");
            stack.pop();
        }
        bufferedWriter.close();
    }
}
