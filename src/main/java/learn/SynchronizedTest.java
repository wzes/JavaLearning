package learn;

/**
 * @author Create by xuantang
 * @date on 8/13/18
 */
public class SynchronizedTest {

    volatile int b = 1;

    public synchronized void test() {
        synchronized (this) {
            b = 3;
            int c = 1;
            int a = b;
        }
    }
}
