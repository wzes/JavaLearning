package interrunpt;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Create by xuantang
 * @date on 9/2/18
 */
public class InterruptTest extends Thread {
    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancel = false;

    InterruptTest(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancel) {
                queue.put(p = p.nextProbablePrime());
                System.out.println("1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel() { interrupt(); }

    public void cancel1() { cancel = true; }


    public static void main(String[] args) {
        BlockingQueue<BigInteger> primes = new ArrayBlockingQueue<>(10);
        InterruptTest interruptTest = new InterruptTest(primes);

        interruptTest.start();

        try {
            Thread.sleep(1000);
            interruptTest.cancel();

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
