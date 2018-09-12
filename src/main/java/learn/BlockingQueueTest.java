package learn;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Create by xuantang
 * @date on 8/14/18
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.offer("Ssssssssss");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String take = null;
                try {
                    take = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(take);
            }
        }).start();
    }
}
