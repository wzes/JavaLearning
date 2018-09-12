package learn;

/**
 * @author Create by xuantang
 * @date on 8/10/18
 */
public class ClassTypeTest {
    static {
        System.out.println("static initialize");
    }

    public Object lock = new Object();
    public ClassTypeTest() {
        System.out.println("construct");
    }

    public synchronized void test6() {
        System.out.println("test6");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test5() {
        System.out.println("test5");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        synchronized (lock) {
            try {
                lock.wait();
                System.out.println("test2");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test4() {
        synchronized (lock) {
            try {
                lock.wait();
                System.out.println("test4");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void test3() {
        synchronized (lock) {
            try {
                lock.notifyAll();
                System.out.println("test3");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    {
        System.out.println("non static initialize");
    }
}
