package message_buffer_v2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = Result.getInputMessage();
        Result.buffer(input);
        Result.resolve();
    }

}
