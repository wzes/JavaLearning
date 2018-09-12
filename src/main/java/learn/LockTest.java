package learn;

/**
 * @author Create by xuantang
 * @date on 8/22/18
 */
public class LockTest {

    static Object lock = new Object();

    public static void main(String[] args) {
        new WaitThread("one").start();
        new WaitThread("two").start();
        new WaitThread("three").start();
        new NotifyThread("four").start();
    }

    static class WaitThread extends Thread {
        WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            synchronized (lock) {
                try {
                    System.out.println(this.getName() + " Wait");
                    lock.wait(1000);
                    System.out.println(this.getName() + " Finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class NotifyThread extends Thread {

        NotifyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(this.getName() + " NotifyAll");
                lock.notify();
            }

        }
    }
}
