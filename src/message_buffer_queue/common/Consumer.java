package message_buffer_queue.common;


//Sử dụng messages đã được cung cấp bên Producer
public class Consumer extends Thread {
    private final Buffer consBuf;

    public Consumer(Buffer buf) {
        consBuf = buf;
    }

    public void run() {
        String value;
        try {
            value = consBuf.get();

            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
    }
}
