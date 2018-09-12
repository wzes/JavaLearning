package learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Create by xuantang
 * @date on 8/22/18
 */
public class ReentrantLockDemo {
    private static ReentrantLock mLock = new ReentrantLock(false);
    private static Condition mCondition = mLock.newCondition();

    private Condition condition;

    public static void main(String[] args) {
        for (int i = 0 ; i < 100; i++) {
            new WaitThread("waiter " + i).start();
        }
        new NotifyThread("notify one").start();
        new NotifyThread("notify two").start();
    }

    static class WaitThread extends Thread {
        WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                mLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(this.getName() + " Waiting......");
                mCondition.await();
                System.out.println(this.getName() + " Finished.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mLock.unlock();
            }
        }
    }

    static class NotifyThread extends Thread {

        NotifyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                mLock.lockInterruptibly();

                mCondition.signal();
                System.out.println(this.getName() + " Notify.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mLock.unlock();
            }
        }
    }
}
