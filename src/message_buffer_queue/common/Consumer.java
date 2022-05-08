package message_buffer_queue.common;

public class Consumer extends Thread {
    private final Buffer consBuf;

    public Consumer(Buffer buf) {
        consBuf = buf;
    }

    public void run() {
        String value;
        try {
            consBuf.get();
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException ignored) {
        }
    }
}
