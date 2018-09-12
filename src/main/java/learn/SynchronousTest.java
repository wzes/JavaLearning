package learn;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Create by xuantang
 * @date on 8/13/18
 */
public class SynchronousTest {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("put thread start");
                    try {
                        queue.put(1);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("put thread end");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });
        putThread.start();
        Thread.sleep(5000);
        takeThread.start();
    }
}
