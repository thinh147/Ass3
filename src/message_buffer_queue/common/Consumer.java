package message_buffer_queue.common;

public class Consumer extends Thread {
    private final Buffer consBuf;

    public Consumer(Buffer buf) {
        consBuf = buf;
    }

    public void run() {
        String value;
        try {
            value = consBuf.get();
        } catch (InterruptedException e) {
            return;
        }
        try {
            Thread.sleep((int) (Math.random() * 100)); // sleep for a randomly chosen time
        } catch (InterruptedException ignored) {
        }
    }
}
